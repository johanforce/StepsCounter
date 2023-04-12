package com.example.stepscounter.presentation.service

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import androidx.core.app.NotificationCompat
import androidx.lifecycle.LifecycleService
import androidx.lifecycle.lifecycleScope
import com.example.stepscounter.R
import com.example.stepscounter.domain.model.DayModel
import com.example.stepscounter.domain.usecase.StepsInDayUseCase
import com.example.stepscounter.domain.usecase.StepsInDaysUseCase
import com.example.stepscounter.presentation.main.MainActivity
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import java.time.LocalDate

class StepCounterService : LifecycleService(), SensorEventListener, KoinComponent {
    private val stepsInDayUseCase: StepsInDaysUseCase by inject()

    private lateinit var sensorManager: SensorManager
    private lateinit var controller: StepCounterController

    companion object {
        private const val NOTIFICATION_CHANNEL_ID = "step_counter_channel"
        private const val NOTIFICATION_ID = 0x1
        private const val PENDING_INTENT_ID = 0x1
    }

    override fun onCreate() {
        super.onCreate()
        val notificationChannel = createNotificationChannel()
        registerNotificationChannel(notificationChannel)
        sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager
        registerStepCounter(sensorManager)

        controller = StepCounterController()

        lifecycleScope.launch {
            val dataDay = stepsInDayUseCase.invoke(LocalDate.now())
            val notification = createNotification(dataDay, dataDay.steps)
            startForeground(NOTIFICATION_ID, notification)
            val notificationManager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.notify(NOTIFICATION_ID, notification)
        }
    }

    private fun createNotification(state: DayModel, steps: Int): Notification = state.run {
        val title = resources.getQuantityString(
            R.plurals.step_count,
            steps,
            steps
        )
        val progress = if (goal == 0) 0 else steps * 100 / goal
        val content = getString(
            R.string.step_counter_stats, calorieBurned.toInt(), distanceTravelled, progress
        )

        NotificationCompat.Builder(this@StepCounterService, NOTIFICATION_CHANNEL_ID)
            .setContentIntent(launchApplicationPendingIntent)
            .setSmallIcon(R.drawable.nature_fill0_wght400_grad0_opsz24)
            .setContentTitle(title)
            .setContentText(content)
            .setOnlyAlertOnce(true)
            .setOngoing(true)
            .setVisibility(NotificationCompat.VISIBILITY_PUBLIC)
            .setSilent(true)
            .build()
    }

    private val launchApplicationPendingIntent
        get(): PendingIntent {
            val intent = Intent(applicationContext, MainActivity::class.java)
            val flags = PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
            return PendingIntent.getActivity(this, PENDING_INTENT_ID, intent, flags)
        }

    private fun registerStepCounter(sensorManager: SensorManager) {
        val stepCounterSensor: Sensor? = sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER)
        stepCounterSensor?.let {
            sensorManager.registerListener(this, it, SensorManager.SENSOR_DELAY_NORMAL)
        }
    }

    override fun onSensorChanged(event: SensorEvent?) {
        event?.let {
            val eventStepCount = it.values[0].toInt()
            controller.onStepCountChanged(eventStepCount, LocalDate.now()) {
                lifecycleScope.launch {
                    val dataDay = stepsInDayUseCase.invoke(LocalDate.now())
                    val steps = if(controller.currentSteps == 0) dataDay.steps else controller.currentSteps
                    val notification = createNotification(dataDay, steps)
                    startForeground(NOTIFICATION_ID, notification)
                    val notificationManager =
                        getSystemService(NOTIFICATION_SERVICE) as NotificationManager
                    notificationManager.notify(NOTIFICATION_ID, notification)
                }
            }
        }
    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {}

    override fun onDestroy() {
        super.onDestroy()
        sensorManager.unregisterListener(this)
    }

    private fun createNotificationChannel(): NotificationChannel {
        val name = getString(R.string.step_counter_channel)
        val importance = NotificationManager.IMPORTANCE_DEFAULT

        return NotificationChannel(NOTIFICATION_CHANNEL_ID, name, importance).apply {
            setShowBadge(false)
        }
    }

    private fun registerNotificationChannel(channel: NotificationChannel) {
        val notificationManager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.createNotificationChannel(channel)
    }
}