package com.example.stepscounter.domain.usecase

import org.koin.core.component.KoinComponent

abstract class BaseUseCase<Output, in Input> : KoinComponent {
    abstract operator fun invoke(input: Input): Output
}

abstract class BaseUseCases<Output, in Input> : KoinComponent {
    abstract suspend operator fun invoke(input: Input): Output
}

abstract class NoResultBaseUseCase<in Input> : KoinComponent {
    abstract suspend operator fun invoke(input: Input)
}

abstract class BaseUseCaseInt<Output, in Input> : KoinComponent {
    abstract suspend operator fun invoke(input: Int): Output
}

abstract class BaseUseCaseString<Output, in Input> : KoinComponent {
    abstract suspend operator fun invoke(input: String): Output
}

abstract class NoParamUseCase<Output> : BaseUseCase<Output, Empty>() {
    override fun invoke(input: Empty): Output {
        return invoke()
    }
    abstract operator fun invoke(): Output
}

abstract class NoParamUseCases<Output> : BaseUseCase<Output, Empty>() {
    abstract suspend operator fun invoke(): Output
}
