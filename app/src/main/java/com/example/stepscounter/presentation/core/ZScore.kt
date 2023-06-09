package com.example.stepscounter.presentation.core

import com.example.stepscounter.common.constant.Constant

object ZScore {
    private val mapLMSBoy2to19 = HashMap<Int, LMS>()
    private val mapLMSGirl2to19= HashMap<Int, LMS>()

    init {
        initLMSBoy5To19()
        initLMSGirl5To19()
    }

    fun getLMSByAgeMonth(ageMonth: Int, gender: Int): LMS? {
        return if (gender == Constant.GENDER_FEMALE) {
            mapLMSGirl2to19[ageMonth]
        } else mapLMSBoy2to19[ageMonth]
    }

    private fun initLMSBoy5To19() {
        mapLMSBoy2to19[24] = LMS(-0.6187, 16.0189, 0.07785)
        mapLMSBoy2to19[25] = LMS(-0.5840, 15.9800, 0.07792)
        mapLMSBoy2to19[26] = LMS(-0.5497, 15.9414, 0.07800)
        mapLMSBoy2to19[27] = LMS(-0.5166, 15.9036, 0.07808)
        mapLMSBoy2to19[28] = LMS(-0.4850, 15.8667, 0.07818)
        mapLMSBoy2to19[29] = LMS(-0.4552, 15.8306, 0.07829)
        mapLMSBoy2to19[30] = LMS(-0.4274, 15.7953, 0.07841)
        mapLMSBoy2to19[31] = LMS(-0.4016, 15.7606, 0.07854)
        mapLMSBoy2to19[32] = LMS(-0.3782, 15.7267, 0.07867)
        mapLMSBoy2to19[33] = LMS(-0.3572, 15.6934, 0.07882)
        mapLMSBoy2to19[34] = LMS(-0.3388, 15.6610, 0.07897)
        mapLMSBoy2to19[35] = LMS(-0.3231, 15.6294, 0.07914)
        mapLMSBoy2to19[36] = LMS(-0.3101, 15.5988, 0.07931)
        mapLMSBoy2to19[37] = LMS(-0.3000, 15.5693, 0.07950)
        mapLMSBoy2to19[38] = LMS(-0.2927, 15.5410, 0.07969)
        mapLMSBoy2to19[39] = LMS(-0.2884, 15.5140, 0.07990)
        mapLMSBoy2to19[40] = LMS(-0.2869, 15.4885, 0.08012)
        mapLMSBoy2to19[41] = LMS(-0.2881, 15.4645, 0.08036)
        mapLMSBoy2to19[42] = LMS(-0.2919, 15.4420, 0.08061)
        mapLMSBoy2to19[43] = LMS(-0.2981, 15.4210, 0.08087)
        mapLMSBoy2to19[44] = LMS(-0.3067, 15.4013, 0.08115)
        mapLMSBoy2to19[45] =
            LMS(-0.3174, 15.3827, 0.08144)
        mapLMSBoy2to19[46] =
            LMS(-0.3303, 15.3652, 0.08174)
        mapLMSBoy2to19[47] =
            LMS(-0.3452, 15.3485, 0.08205)
        mapLMSBoy2to19[48] =
            LMS(-0.3622, 15.3326, 0.08238)
        mapLMSBoy2to19[49] =
            LMS(-0.3811, 15.3174, 0.08272)
        mapLMSBoy2to19[50] =
            LMS(-0.4019, 15.3029, 0.08307)
        mapLMSBoy2to19[51] =
            LMS(-0.4245, 15.2891, 0.08343)
        mapLMSBoy2to19[52] =
            LMS(-0.4488, 15.2759, 0.08380)
        mapLMSBoy2to19[53] =
            LMS(-0.4747, 15.2633, 0.08418)
        mapLMSBoy2to19[54] =
            LMS(-0.5019, 15.2514, 0.08457)
        mapLMSBoy2to19[55] =
            LMS(-0.5303, 15.2400, 0.08496)
        mapLMSBoy2to19[56] =
            LMS(-0.5599, 15.2291, 0.08536)
        mapLMSBoy2to19[57] =
            LMS(-0.5905, 15.2188, 0.08577)
        mapLMSBoy2to19[58] =
            LMS(-0.6223, 15.2091, 0.08617)
        mapLMSBoy2to19[59] =
            LMS(-0.6552, 15.2000, 0.08659)
        mapLMSBoy2to19[60] =
            LMS(-0.6892, 15.1916, 0.08700)
        mapLMSBoy2to19[61] =
            LMS(-0.7387, 15.2641, 0.0839)
        mapLMSBoy2to19[62] =
            LMS(-0.7621, 15.2616, 0.08414)
        mapLMSBoy2to19[63] =
            LMS(-0.7856, 15.2604, 0.08439)
        mapLMSBoy2to19[64] =
            LMS(-0.8089, 15.2605, 0.08464)
        mapLMSBoy2to19[65] =
            LMS(-0.8322, 15.2619, 0.0849)
        mapLMSBoy2to19[66] =
            LMS(-0.8554, 15.2645, 0.08516)
        mapLMSBoy2to19[67] =
            LMS(-0.8785, 15.2684, 0.08543)
        mapLMSBoy2to19[68] =
            LMS(-0.9015, 15.2737, 0.0857)
        mapLMSBoy2to19[69] =
            LMS(-0.9243, 15.2801, 0.08597)
        mapLMSBoy2to19[70] =
            LMS(-0.9471, 15.2877, 0.08625)
        mapLMSBoy2to19[71] =
            LMS(-0.9697, 15.2965, 0.08653)
        mapLMSBoy2to19[72] =
            LMS(-0.9921, 15.3062, 0.08682)
        mapLMSBoy2to19[73] =
            LMS(-1.0144, 15.3169, 0.08711)
        mapLMSBoy2to19[74] =
            LMS(-1.0365, 15.3285, 0.08741)
        mapLMSBoy2to19[75] =
            LMS(-1.0584, 15.3408, 0.08771)
        mapLMSBoy2to19[76] =
            LMS(-1.0801, 15.354, 0.08802)
        mapLMSBoy2to19[77] =
            LMS(-1.1017, 15.3679, 0.08833)
        mapLMSBoy2to19[78] =
            LMS(-1.123, 15.3825, 0.08865)
        mapLMSBoy2to19[79] =
            LMS(-1.1441, 15.3978, 0.08898)
        mapLMSBoy2to19[80] =
            LMS(-1.1649, 15.4137, 0.08931)
        mapLMSBoy2to19[81] =
            LMS(-1.1856, 15.4302, 0.08964)
        mapLMSBoy2to19[82] =
            LMS(-1.206, 15.4473, 0.08998)
        mapLMSBoy2to19[83] =
            LMS(-1.2261, 15.465, 0.09033)
        mapLMSBoy2to19[84] =
            LMS(-1.246, 15.4832, 0.09068)
        mapLMSBoy2to19[85] =
            LMS(-1.2656, 15.5019, 0.09103)
        mapLMSBoy2to19[86] =
            LMS(-1.2849, 15.521, 0.09139)
        mapLMSBoy2to19[87] =
            LMS(-1.304, 15.5407, 0.09176)
        mapLMSBoy2to19[88] =
            LMS(-1.3228, 15.5608, 0.09213)
        mapLMSBoy2to19[89] =
            LMS(-1.3414, 15.5814, 0.09251)
        mapLMSBoy2to19[90] =
            LMS(-1.3596, 15.6023, 0.09289)
        mapLMSBoy2to19[91] =
            LMS(-1.3776, 15.6237, 0.09327)
        mapLMSBoy2to19[92] =
            LMS(-1.3953, 15.6455, 0.09366)
        mapLMSBoy2to19[93] =
            LMS(-1.4126, 15.6677, 0.09406)
        mapLMSBoy2to19[94] =
            LMS(-1.4297, 15.6903, 0.09445)
        mapLMSBoy2to19[95] =
            LMS(-1.4464, 15.7133, 0.09486)
        mapLMSBoy2to19[96] =
            LMS(-1.4629, 15.7368, 0.09526)
        mapLMSBoy2to19[97] =
            LMS(-1.479, 15.7606, 0.09567)
        mapLMSBoy2to19[98] =
            LMS(-1.4947, 15.7848, 0.09609)
        mapLMSBoy2to19[99] =
            LMS(-1.5101, 15.8094, 0.09651)
        mapLMSBoy2to19[100] =
            LMS(-1.5252, 15.8344, 0.09693)
        mapLMSBoy2to19[101] =
            LMS(-1.5399, 15.8597, 0.09735)
        mapLMSBoy2to19[102] =
            LMS(-1.5542, 15.8855, 0.09778)
        mapLMSBoy2to19[103] =
            LMS(-1.5681, 15.9116, 0.09821)
        mapLMSBoy2to19[104] =
            LMS(-1.5817, 15.9381, 0.09864)
        mapLMSBoy2to19[105] =
            LMS(-1.5948, 15.9651, 0.09907)
        mapLMSBoy2to19[106] =
            LMS(-1.6076, 15.9925, 0.09951)
        mapLMSBoy2to19[107] =
            LMS(-1.6199, 16.0205, 0.09994)
        mapLMSBoy2to19[108] =
            LMS(-1.6318, 16.049, 0.10038)
        mapLMSBoy2to19[109] =
            LMS(-1.6433, 16.0781, 0.10082)
        mapLMSBoy2to19[110] =
            LMS(-1.6544, 16.1078, 0.10126)
        mapLMSBoy2to19[111] =
            LMS(-1.6651, 16.1381, 0.1017)
        mapLMSBoy2to19[112] =
            LMS(-1.6753, 16.1692, 0.10214)
        mapLMSBoy2to19[113] =
            LMS(-1.6851, 16.2009, 0.10259)
        mapLMSBoy2to19[114] =
            LMS(-1.6944, 16.2333, 0.10303)
        mapLMSBoy2to19[115] =
            LMS(-1.7032, 16.2665, 0.10347)
        mapLMSBoy2to19[116] =
            LMS(-1.7116, 16.3004, 0.10391)
        mapLMSBoy2to19[117] =
            LMS(-1.7196, 16.3351, 0.10435)
        mapLMSBoy2to19[118] =
            LMS(-1.7271, 16.3704, 0.10478)
        mapLMSBoy2to19[119] =
            LMS(-1.7341, 16.4065, 0.10522)
        mapLMSBoy2to19[120] =
            LMS(-1.7407, 16.4433, 0.10566)
        mapLMSBoy2to19[121] =
            LMS(-1.7468, 16.4807, 0.10609)
        mapLMSBoy2to19[122] =
            LMS(-1.7525, 16.5189, 0.10652)
        mapLMSBoy2to19[123] =
            LMS(-1.7578, 16.5578, 0.10695)
        mapLMSBoy2to19[124] =
            LMS(-1.7626, 16.5974, 0.10738)
        mapLMSBoy2to19[125] =
            LMS(-1.767, 16.6376, 0.1078)
        mapLMSBoy2to19[126] =
            LMS(-1.771, 16.6786, 0.10823)
        mapLMSBoy2to19[127] =
            LMS(-1.7745, 16.7203, 0.10865)
        mapLMSBoy2to19[128] =
            LMS(-1.7777, 16.7628, 0.10906)
        mapLMSBoy2to19[129] =
            LMS(-1.7804, 16.8059, 0.10948)
        mapLMSBoy2to19[130] =
            LMS(-1.7828, 16.8497, 0.10989)
        mapLMSBoy2to19[131] =
            LMS(-1.7847, 16.8941, 0.1103)
        mapLMSBoy2to19[132] =
            LMS(-1.7862, 16.9392, 0.1107)
        mapLMSBoy2to19[133] =
            LMS(-1.7873, 16.985, 0.1111)
        mapLMSBoy2to19[134] =
            LMS(-1.7881, 17.0314, 0.1115)
        mapLMSBoy2to19[135] =
            LMS(-1.7884, 17.0784, 0.11189)
        mapLMSBoy2to19[136] =
            LMS(-1.7884, 17.1262, 0.11228)
        mapLMSBoy2to19[137] =
            LMS(-1.788, 17.1746, 0.11266)
        mapLMSBoy2to19[138] =
            LMS(-1.7873, 17.2236, 0.11304)
        mapLMSBoy2to19[139] =
            LMS(-1.7861, 17.2734, 0.11342)
        mapLMSBoy2to19[140] =
            LMS(-1.7846, 17.324, 0.11379)
        mapLMSBoy2to19[141] =
            LMS(-1.7828, 17.3752, 0.11415)
        mapLMSBoy2to19[142] =
            LMS(-1.7806, 17.4272, 0.11451)
        mapLMSBoy2to19[143] =
            LMS(-1.778, 17.4799, 0.11487)
        mapLMSBoy2to19[144] =
            LMS(-1.7751, 17.5334, 0.11522)
        mapLMSBoy2to19[145] =
            LMS(-1.7719, 17.5877, 0.11556)
        mapLMSBoy2to19[146] =
            LMS(-1.7684, 17.6427, 0.1159)
        mapLMSBoy2to19[147] =
            LMS(-1.7645, 17.6985, 0.11623)
        mapLMSBoy2to19[148] =
            LMS(-1.7604, 17.7551, 0.11656)
        mapLMSBoy2to19[149] =
            LMS(-1.7559, 17.8124, 0.11688)
        mapLMSBoy2to19[150] =
            LMS(-1.7511, 17.8704, 0.1172)
        mapLMSBoy2to19[151] =
            LMS(-1.7461, 17.9292, 0.11751)
        mapLMSBoy2to19[152] =
            LMS(-1.7408, 17.9887, 0.11781)
        mapLMSBoy2to19[153] =
            LMS(-1.7352, 18.0488, 0.11811)
        mapLMSBoy2to19[154] =
            LMS(-1.7293, 18.1096, 0.11841)
        mapLMSBoy2to19[155] =
            LMS(-1.7232, 18.171, 0.11869)
        mapLMSBoy2to19[156] =
            LMS(-1.7168, 18.233, 0.11898)
        mapLMSBoy2to19[157] =
            LMS(-1.7102, 18.2955, 0.11925)
        mapLMSBoy2to19[158] =
            LMS(-1.7033, 18.3586, 0.11952)
        mapLMSBoy2to19[159] =
            LMS(-1.6962, 18.4221, 0.11979)
        mapLMSBoy2to19[160] =
            LMS(-1.6888, 18.486, 0.12005)
        mapLMSBoy2to19[161] =
            LMS(-1.6811, 18.5502, 0.1203)
        mapLMSBoy2to19[162] =
            LMS(-1.6732, 18.6148, 0.12055)
        mapLMSBoy2to19[163] =
            LMS(-1.6651, 18.6795, 0.12079)
        mapLMSBoy2to19[164] =
            LMS(-1.6568, 18.7445, 0.12102)
        mapLMSBoy2to19[165] =
            LMS(-1.6482, 18.8095, 0.12125)
        mapLMSBoy2to19[166] =
            LMS(-1.6394, 18.8746, 0.12148)
        mapLMSBoy2to19[167] =
            LMS(-1.6304, 18.9398, 0.1217)
        mapLMSBoy2to19[168] =
            LMS(-1.6211, 19.005, 0.12191)
        mapLMSBoy2to19[169] =
            LMS(-1.6116, 19.0701, 0.12212)
        mapLMSBoy2to19[170] =
            LMS(-1.602, 19.1351, 0.12233)
        mapLMSBoy2to19[171] =
            LMS(-1.5921, 19.2, 0.12253)
        mapLMSBoy2to19[172] =
            LMS(-1.5821, 19.2648, 0.12272)
        mapLMSBoy2to19[173] =
            LMS(-1.5719, 19.3294, 0.12291)
        mapLMSBoy2to19[174] =
            LMS(-1.5615, 19.3937, 0.1231)
        mapLMSBoy2to19[175] =
            LMS(-1.551, 19.4578, 0.12328)
        mapLMSBoy2to19[176] =
            LMS(-1.5403, 19.5217, 0.12346)
        mapLMSBoy2to19[177] =
            LMS(-1.5294, 19.5853, 0.12363)
        mapLMSBoy2to19[178] =
            LMS(-1.5185, 19.6486, 0.1238)
        mapLMSBoy2to19[179] =
            LMS(-1.5074, 19.7117, 0.12396)
        mapLMSBoy2to19[180] =
            LMS(-1.4961, 19.7744, 0.12412)
        mapLMSBoy2to19[181] =
            LMS(-1.4848, 19.8367, 0.12428)
        mapLMSBoy2to19[182] =
            LMS(-1.4733, 19.8987, 0.12443)
        mapLMSBoy2to19[183] =
            LMS(-1.4617, 19.9603, 0.12458)
        mapLMSBoy2to19[184] =
            LMS(-1.45, 20.0215, 0.12473)
        mapLMSBoy2to19[185] =
            LMS(-1.4382, 20.0823, 0.12487)
        mapLMSBoy2to19[186] =
            LMS(-1.4263, 20.1427, 0.12501)
        mapLMSBoy2to19[187] =
            LMS(-1.4143, 20.2026, 0.12514)
        mapLMSBoy2to19[188] =
            LMS(-1.4022, 20.2621, 0.12528)
        mapLMSBoy2to19[189] =
            LMS(-1.39, 20.3211, 0.12541)
        mapLMSBoy2to19[190] =
            LMS(-1.3777, 20.3796, 0.12554)
        mapLMSBoy2to19[191] =
            LMS(-1.3653, 20.4376, 0.12567)
        mapLMSBoy2to19[192] =
            LMS(-1.3529, 20.4951, 0.12579)
        mapLMSBoy2to19[193] =
            LMS(-1.3403, 20.5521, 0.12591)
        mapLMSBoy2to19[194] =
            LMS(-1.3277, 20.6085, 0.12603)
        mapLMSBoy2to19[195] =
            LMS(-1.3149, 20.6644, 0.12615)
        mapLMSBoy2to19[196] =
            LMS(-1.3021, 20.7197, 0.12627)
        mapLMSBoy2to19[197] =
            LMS(-1.2892, 20.7745, 0.12638)
        mapLMSBoy2to19[198] =
            LMS(-1.2762, 20.8287, 0.1265)
        mapLMSBoy2to19[199] =
            LMS(-1.2631, 20.8824, 0.12661)
        mapLMSBoy2to19[200] =
            LMS(-1.2499, 20.9355, 0.12672)
        mapLMSBoy2to19[201] =
            LMS(-1.2366, 20.9881, 0.12683)
        mapLMSBoy2to19[202] =
            LMS(-1.2233, 21.04, 0.12694)
        mapLMSBoy2to19[203] =
            LMS(-1.2098, 21.0914, 0.12704)
        mapLMSBoy2to19[204] =
            LMS(-1.1962, 21.1423, 0.12715)
        mapLMSBoy2to19[205] =
            LMS(-1.1826, 21.1925, 0.12726)
        mapLMSBoy2to19[206] =
            LMS(-1.1688, 21.2423, 0.12736)
        mapLMSBoy2to19[207] =
            LMS(-1.155, 21.2914, 0.12746)
        mapLMSBoy2to19[208] =
            LMS(-1.141, 21.34, 0.12756)
        mapLMSBoy2to19[209] =
            LMS(-1.127, 21.388, 0.12767)
        mapLMSBoy2to19[210] =
            LMS(-1.1129, 21.4354, 0.12777)
        mapLMSBoy2to19[211] =
            LMS(-1.0986, 21.4822, 0.12787)
        mapLMSBoy2to19[212] =
            LMS(-1.0843, 21.5285, 0.12797)
        mapLMSBoy2to19[213] =
            LMS(-1.0699, 21.5742, 0.12807)
        mapLMSBoy2to19[214] =
            LMS(-1.0553, 21.6193, 0.12816)
        mapLMSBoy2to19[215] =
            LMS(-1.0407, 21.6638, 0.12826)
        mapLMSBoy2to19[216] =
            LMS(-1.026, 21.7077, 0.12836)
        mapLMSBoy2to19[217] =
            LMS(-1.0112, 21.751, 0.12845)
        mapLMSBoy2to19[218] =
            LMS(-0.9962, 21.7937, 0.12855)
        mapLMSBoy2to19[219] =
            LMS(-0.9812, 21.8358, 0.12864)
        mapLMSBoy2to19[220] =
            LMS(-0.9661, 21.8773, 0.12874)
        mapLMSBoy2to19[221] =
            LMS(-0.9509, 21.9182, 0.12883)
        mapLMSBoy2to19[222] =
            LMS(-0.9356, 21.9585, 0.12893)
        mapLMSBoy2to19[223] =
            LMS(-0.9202, 21.9982, 0.12902)
        mapLMSBoy2to19[224] =
            LMS(-0.9048, 22.0374, 0.12911)
        mapLMSBoy2to19[225] =
            LMS(-0.8892, 22.076, 0.1292)
        mapLMSBoy2to19[226] =
            LMS(-0.8735, 22.114, 0.1293)
        mapLMSBoy2to19[227] =
            LMS(-0.8578, 22.1514, 0.12939)
        mapLMSBoy2to19[228] =
            LMS(-0.8419, 22.1883, 0.12948)
    }

    private fun initLMSGirl5To19() {
        mapLMSGirl2to19[24] =
            LMS(-0.5684, 15.6881, 0.08454)
        mapLMSGirl2to19[25] =
            LMS(-0.5684, 15.6590, 0.08452)
        mapLMSGirl2to19[26] =
            LMS(-0.5684, 15.6308, 0.08449)
        mapLMSGirl2to19[27] =
            LMS(-0.5684, 15.6037, 0.08446)
        mapLMSGirl2to19[28] =
            LMS(-0.5684, 15.5777, 0.08444)
        mapLMSGirl2to19[29] =
            LMS(-0.5684, 15.5523, 0.08443)
        mapLMSGirl2to19[30] =
            LMS(-0.5684, 15.5276, 0.08444)
        mapLMSGirl2to19[31] =
            LMS(-0.5684, 15.5034, 0.08448)
        mapLMSGirl2to19[32] =
            LMS(-0.5684, 15.4798, 0.08455)
        mapLMSGirl2to19[33] =
            LMS(-0.5684, 15.4572, 0.08467)
        mapLMSGirl2to19[34] =
            LMS(-0.5684, 15.4356, 0.08484)
        mapLMSGirl2to19[35] =
            LMS(-0.5684, 15.4155, 0.08506)
        mapLMSGirl2to19[36] =
            LMS(-0.5684, 15.3968, 0.08535)
        mapLMSGirl2to19[37] =
            LMS(-0.5684, 15.3796, 0.08569)
        mapLMSGirl2to19[38] =
            LMS(-0.5684, 15.3638, 0.08609)
        mapLMSGirl2to19[39] =
            LMS(-0.5684, 15.3493, 0.08654)
        mapLMSGirl2to19[40] =
            LMS(-0.5684, 15.3358, 0.08704)
        mapLMSGirl2to19[41] =
            LMS(-0.5684, 15.3233, 0.08757)
        mapLMSGirl2to19[42] =
            LMS(-0.5684, 15.3116, 0.08813)
        mapLMSGirl2to19[43] =
            LMS(-0.5684, 15.3007, 0.08872)
        mapLMSGirl2to19[44] =
            LMS(-0.5684, 15.2905, 0.08931)
        mapLMSGirl2to19[45] =
            LMS(-0.5684, 15.2814, 0.08991)
        mapLMSGirl2to19[46] =
            LMS(-0.5684, 15.2732, 0.09051)
        mapLMSGirl2to19[47] =
            LMS(-0.5684, 15.2661, 0.09110)
        mapLMSGirl2to19[48] =
            LMS(-0.5684, 15.2602, 0.09168)
        mapLMSGirl2to19[49] =
            LMS(-0.5684, 15.2556, 0.09227)
        mapLMSGirl2to19[50] =
            LMS(-0.5684, 15.2523, 0.09286)
        mapLMSGirl2to19[51] =
            LMS(-0.5684, 15.2503, 0.09345)
        mapLMSGirl2to19[52] =
            LMS(-0.5684, 15.2496, 0.09403)
        mapLMSGirl2to19[53] =
            LMS(-0.5684, 15.2502, 0.09460)
        mapLMSGirl2to19[54] =
            LMS(-0.5684, 15.2519, 0.09515)
        mapLMSGirl2to19[55] =
            LMS(-0.5684, 15.2544, 0.09568)
        mapLMSGirl2to19[56] =
            LMS(-0.5684, 15.2575, 0.09618)
        mapLMSGirl2to19[57] =
            LMS(-0.5684, 15.2612, 0.09665)
        mapLMSGirl2to19[58] =
            LMS(-0.5684, 15.2653, 0.09709)
        mapLMSGirl2to19[59] =
            LMS(-0.5684, 15.2698, 0.09750)
        mapLMSGirl2to19[60] =
            LMS(-0.5684, 15.2747, 0.09789)
        mapLMSGirl2to19[61] =
            LMS(-0.8886, 15.2441, 0.09692)
        mapLMSGirl2to19[62] =
            LMS(-0.9068, 15.2434, 0.09738)
        mapLMSGirl2to19[63] =
            LMS(-0.9248, 15.2433, 0.09783)
        mapLMSGirl2to19[64] =
            LMS(-0.9427, 15.2438, 0.09829)
        mapLMSGirl2to19[65] =
            LMS(-0.9605, 15.2448, 0.09875)
        mapLMSGirl2to19[66] =
            LMS(-0.978, 15.2464, 0.0992)
        mapLMSGirl2to19[67] =
            LMS(-0.9954, 15.2487, 0.09966)
        mapLMSGirl2to19[68] =
            LMS(-1.0126, 15.2516, 0.10012)
        mapLMSGirl2to19[69] =
            LMS(-1.0296, 15.2551, 0.10058)
        mapLMSGirl2to19[70] =
            LMS(-1.0464, 15.2592, 0.10104)
        mapLMSGirl2to19[71] =
            LMS(-1.063, 15.2641, 0.10149)
        mapLMSGirl2to19[72] =
            LMS(-1.0794, 15.2697, 0.10195)
        mapLMSGirl2to19[73] =
            LMS(-1.0956, 15.276, 0.10241)
        mapLMSGirl2to19[74] =
            LMS(-1.1115, 15.2831, 0.10287)
        mapLMSGirl2to19[75] =
            LMS(-1.1272, 15.2911, 0.10333)
        mapLMSGirl2to19[76] =
            LMS(-1.1427, 15.2998, 0.10379)
        mapLMSGirl2to19[77] =
            LMS(-1.1579, 15.3095, 0.10425)
        mapLMSGirl2to19[78] =
            LMS(-1.1728, 15.32, 0.10471)
        mapLMSGirl2to19[79] =
            LMS(-1.1875, 15.3314, 0.10517)
        mapLMSGirl2to19[80] =
            LMS(-1.2019, 15.3439, 0.10562)
        mapLMSGirl2to19[81] =
            LMS(-1.216, 15.3572, 0.10608)
        mapLMSGirl2to19[82] =
            LMS(-1.2298, 15.3717, 0.10654)
        mapLMSGirl2to19[83] =
            LMS(-1.2433, 15.3871, 0.107)
        mapLMSGirl2to19[84] =
            LMS(-1.2565, 15.4036, 0.10746)
        mapLMSGirl2to19[85] =
            LMS(-1.2693, 15.4211, 0.10792)
        mapLMSGirl2to19[86] =
            LMS(-1.2819, 15.4397, 0.10837)
        mapLMSGirl2to19[87] =
            LMS(-1.2941, 15.4593, 0.10883)
        mapLMSGirl2to19[88] =
            LMS(-1.306, 15.4798, 0.10929)
        mapLMSGirl2to19[89] =
            LMS(-1.3175, 15.5014, 0.10974)
        mapLMSGirl2to19[90] =
            LMS(-1.3287, 15.524, 0.1102)
        mapLMSGirl2to19[91] =
            LMS(-1.3395, 15.5476, 0.11065)
        mapLMSGirl2to19[92] =
            LMS(-1.3499, 15.5723, 0.1111)
        mapLMSGirl2to19[93] =
            LMS(-1.36, 15.5979, 0.11156)
        mapLMSGirl2to19[94] =
            LMS(-1.3697, 15.6246, 0.11201)
        mapLMSGirl2to19[95] =
            LMS(-1.379, 15.6523, 0.11246)
        mapLMSGirl2to19[96] =
            LMS(-1.388, 15.681, 0.11291)
        mapLMSGirl2to19[97] =
            LMS(-1.3966, 15.7107, 0.11335)
        mapLMSGirl2to19[98] =
            LMS(-1.4047, 15.7415, 0.1138)
        mapLMSGirl2to19[99] =
            LMS(-1.4125, 15.7732, 0.11424)
        mapLMSGirl2to19[100] =
            LMS(-1.4199, 15.8058, 0.11469)
        mapLMSGirl2to19[101] =
            LMS(-1.427, 15.8394, 0.11513)
        mapLMSGirl2to19[102] =
            LMS(-1.4336, 15.8738, 0.11557)
        mapLMSGirl2to19[103] =
            LMS(-1.4398, 15.909, 0.11601)
        mapLMSGirl2to19[104] =
            LMS(-1.4456, 15.9451, 0.11644)
        mapLMSGirl2to19[105] =
            LMS(-1.4511, 15.9818, 0.11688)
        mapLMSGirl2to19[106] =
            LMS(-1.4561, 16.0194, 0.11731)
        mapLMSGirl2to19[107] =
            LMS(-1.4607, 16.0575, 0.11774)
        mapLMSGirl2to19[108] =
            LMS(-1.465, 16.0964, 0.11816)
        mapLMSGirl2to19[109] =
            LMS(-1.4688, 16.1358, 0.11859)
        mapLMSGirl2to19[110] =
            LMS(-1.4723, 16.1759, 0.11901)
        mapLMSGirl2to19[111] =
            LMS(-1.4753, 16.2166, 0.11943)
        mapLMSGirl2to19[112] =
            LMS(-1.478, 16.258, 0.11985)
        mapLMSGirl2to19[113] =
            LMS(-1.4803, 16.2999, 0.12026)
        mapLMSGirl2to19[114] =
            LMS(-1.4823, 16.3425, 0.12067)
        mapLMSGirl2to19[115] =
            LMS(-1.4838, 16.3858, 0.12108)
        mapLMSGirl2to19[116] =
            LMS(-1.485, 16.4298, 0.12148)
        mapLMSGirl2to19[117] =
            LMS(-1.4859, 16.4746, 0.12188)
        mapLMSGirl2to19[118] =
            LMS(-1.4864, 16.52, 0.12228)
        mapLMSGirl2to19[119] =
            LMS(-1.4866, 16.5663, 0.12268)
        mapLMSGirl2to19[120] =
            LMS(-1.4864, 16.6133, 0.12307)
        mapLMSGirl2to19[121] =
            LMS(-1.4859, 16.6612, 0.12346)
        mapLMSGirl2to19[122] =
            LMS(-1.4851, 16.71, 0.12384)
        mapLMSGirl2to19[123] =
            LMS(-1.4839, 16.7595, 0.12422)
        mapLMSGirl2to19[124] =
            LMS(-1.4825, 16.81, 0.1246)
        mapLMSGirl2to19[125] =
            LMS(-1.4807, 16.8614, 0.12497)
        mapLMSGirl2to19[126] =
            LMS(-1.4787, 16.9136, 0.12534)
        mapLMSGirl2to19[127] =
            LMS(-1.4763, 16.9667, 0.12571)
        mapLMSGirl2to19[128] =
            LMS(-1.4737, 17.0208, 0.12607)
        mapLMSGirl2to19[129] =
            LMS(-1.4708, 17.0757, 0.12643)
        mapLMSGirl2to19[130] =
            LMS(-1.4677, 17.1316, 0.12678)
        mapLMSGirl2to19[131] =
            LMS(-1.4642, 17.1883, 0.12713)
        mapLMSGirl2to19[132] =
            LMS(-1.4606, 17.2459, 0.12748)
        mapLMSGirl2to19[133] =
            LMS(-1.4567, 17.3044, 0.12782)
        mapLMSGirl2to19[134] =
            LMS(-1.4526, 17.3637, 0.12816)
        mapLMSGirl2to19[135] =
            LMS(-1.4482, 17.4238, 0.12849)
        mapLMSGirl2to19[136] =
            LMS(-1.4436, 17.4847, 0.12882)
        mapLMSGirl2to19[137] =
            LMS(-1.4389, 17.5464, 0.12914)
        mapLMSGirl2to19[138] =
            LMS(-1.4339, 17.6088, 0.12946)
        mapLMSGirl2to19[139] =
            LMS(-1.4288, 17.6719, 0.12978)
        mapLMSGirl2to19[140] =
            LMS(-1.4235, 17.7357, 0.13009)
        mapLMSGirl2to19[141] =
            LMS(-1.418, 17.8001, 0.1304)
        mapLMSGirl2to19[142] =
            LMS(-1.4123, 17.8651, 0.1307)
        mapLMSGirl2to19[143] =
            LMS(-1.4065, 17.9306, 0.13099)
        mapLMSGirl2to19[144] =
            LMS(-1.4006, 17.9966, 0.13129)
        mapLMSGirl2to19[145] =
            LMS(-1.3945, 18.063, 0.13158)
        mapLMSGirl2to19[146] =
            LMS(-1.3883, 18.1297, 0.13186)
        mapLMSGirl2to19[147] =
            LMS(-1.3819, 18.1967, 0.13214)
        mapLMSGirl2to19[148] =
            LMS(-1.3755, 18.2639, 0.13241)
        mapLMSGirl2to19[149] =
            LMS(-1.3689, 18.3312, 0.13268)
        mapLMSGirl2to19[150] =
            LMS(-1.3621, 18.3986, 0.13295)
        mapLMSGirl2to19[151] =
            LMS(-1.3553, 18.466, 0.13321)
        mapLMSGirl2to19[152] =
            LMS(-1.3483, 18.5333, 0.13347)
        mapLMSGirl2to19[153] =
            LMS(-1.3413, 18.6006, 0.13372)
        mapLMSGirl2to19[154] =
            LMS(-1.3341, 18.6677, 0.13397)
        mapLMSGirl2to19[155] =
            LMS(-1.3269, 18.7346, 0.13421)
        mapLMSGirl2to19[156] =
            LMS(-1.3195, 18.8012, 0.13445)
        mapLMSGirl2to19[157] =
            LMS(-1.3121, 18.8675, 0.13469)
        mapLMSGirl2to19[158] =
            LMS(-1.3046, 18.9335, 0.13492)
        mapLMSGirl2to19[159] =
            LMS(-1.297, 18.9991, 0.13514)
        mapLMSGirl2to19[160] =
            LMS(-1.2894, 19.0642, 0.13537)
        mapLMSGirl2to19[161] =
            LMS(-1.2816, 19.1289, 0.13559)
        mapLMSGirl2to19[162] =
            LMS(-1.2739, 19.1931, 0.1358)
        mapLMSGirl2to19[163] =
            LMS(-1.2661, 19.2567, 0.13601)
        mapLMSGirl2to19[164] =
            LMS(-1.2583, 19.3197, 0.13622)
        mapLMSGirl2to19[165] =
            LMS(-1.2504, 19.382, 0.13642)
        mapLMSGirl2to19[166] =
            LMS(-1.2425, 19.4437, 0.13662)
        mapLMSGirl2to19[167] =
            LMS(-1.2345, 19.5045, 0.13681)
        mapLMSGirl2to19[168] =
            LMS(-1.2266, 19.5647, 0.137)
        mapLMSGirl2to19[169] =
            LMS(-1.2186, 19.624, 0.13719)
        mapLMSGirl2to19[170] =
            LMS(-1.2107, 19.6824, 0.13738)
        mapLMSGirl2to19[171] =
            LMS(-1.2027, 19.74, 0.13756)
        mapLMSGirl2to19[172] =
            LMS(-1.1947, 19.7966, 0.13774)
        mapLMSGirl2to19[173] =
            LMS(-1.1867, 19.8523, 0.13791)
        mapLMSGirl2to19[174] =
            LMS(-1.1788, 19.907, 0.13808)
        mapLMSGirl2to19[175] =
            LMS(-1.1708, 19.9607, 0.13825)
        mapLMSGirl2to19[176] =
            LMS(-1.1629, 20.0133, 0.13841)
        mapLMSGirl2to19[177] =
            LMS(-1.1549, 20.0648, 0.13858)
        mapLMSGirl2to19[178] =
            LMS(-1.147, 20.1152, 0.13873)
        mapLMSGirl2to19[179] =
            LMS(-1.139, 20.1644, 0.13889)
        mapLMSGirl2to19[180] =
            LMS(-1.1311, 20.2125, 0.13904)
        mapLMSGirl2to19[181] =
            LMS(-1.1232, 20.2595, 0.1392)
        mapLMSGirl2to19[182] =
            LMS(-1.1153, 20.3053, 0.13934)
        mapLMSGirl2to19[183] =
            LMS(-1.1074, 20.3499, 0.13949)
        mapLMSGirl2to19[184] =
            LMS(-1.0996, 20.3934, 0.13963)
        mapLMSGirl2to19[185] =
            LMS(-1.0917, 20.4357, 0.13977)
        mapLMSGirl2to19[186] =
            LMS(-1.0838, 20.4769, 0.13991)
        mapLMSGirl2to19[187] =
            LMS(-1.076, 20.517, 0.14005)
        mapLMSGirl2to19[188] =
            LMS(-1.0681, 20.556, 0.14018)
        mapLMSGirl2to19[189] =
            LMS(-1.0603, 20.5938, 0.14031)
        mapLMSGirl2to19[190] =
            LMS(-1.0525, 20.6306, 0.14044)
        mapLMSGirl2to19[191] =
            LMS(-1.0447, 20.6663, 0.14057)
        mapLMSGirl2to19[192] =
            LMS(-1.0368, 20.7008, 0.1407)
        mapLMSGirl2to19[193] =
            LMS(-1.029, 20.7344, 0.14082)
        mapLMSGirl2to19[194] =
            LMS(-1.0212, 20.7668, 0.14094)
        mapLMSGirl2to19[195] =
            LMS(-1.0134, 20.7982, 0.14106)
        mapLMSGirl2to19[196] =
            LMS(-1.0055, 20.8286, 0.14118)
        mapLMSGirl2to19[197] =
            LMS(-0.9977, 20.858, 0.1413)
        mapLMSGirl2to19[198] =
            LMS(-0.9898, 20.8863, 0.14142)
        mapLMSGirl2to19[199] =
            LMS(-0.9819, 20.9137, 0.14153)
        mapLMSGirl2to19[200] =
            LMS(-0.974, 20.9401, 0.14164)
        mapLMSGirl2to19[201] =
            LMS(-0.9661, 20.9656, 0.14176)
        mapLMSGirl2to19[202] =
            LMS(-0.9582, 20.9901, 0.14187)
        mapLMSGirl2to19[203] =
            LMS(-0.9503, 21.0138, 0.14198)
        mapLMSGirl2to19[204] =
            LMS(-0.9423, 21.0367, 0.14208)
        mapLMSGirl2to19[205] =
            LMS(-0.9344, 21.0587, 0.14219)
        mapLMSGirl2to19[206] =
            LMS(-0.9264, 21.0801, 0.1423)
        mapLMSGirl2to19[207] =
            LMS(-0.9184, 21.1007, 0.1424)
        mapLMSGirl2to19[208] =
            LMS(-0.9104, 21.1206, 0.1425)
        mapLMSGirl2to19[209] =
            LMS(-0.9024, 21.1399, 0.14261)
        mapLMSGirl2to19[210] =
            LMS(-0.8944, 21.1586, 0.14271)
        mapLMSGirl2to19[211] =
            LMS(-0.8863, 21.1768, 0.14281)
        mapLMSGirl2to19[212] =
            LMS(-0.8783, 21.1944, 0.14291)
        mapLMSGirl2to19[213] =
            LMS(-0.8703, 21.2116, 0.14301)
        mapLMSGirl2to19[214] =
            LMS(-0.8623, 21.2282, 0.14311)
        mapLMSGirl2to19[215] =
            LMS(-0.8542, 21.2444, 0.1432)
        mapLMSGirl2to19[216] =
            LMS(-0.8462, 21.2603, 0.1433)
        mapLMSGirl2to19[217] =
            LMS(-0.8382, 21.2757, 0.1434)
        mapLMSGirl2to19[218] =
            LMS(-0.8301, 21.2908, 0.14349)
        mapLMSGirl2to19[219] =
            LMS(-0.8221, 21.3055, 0.14359)
        mapLMSGirl2to19[220] =
            LMS(-0.814, 21.32, 0.14368)
        mapLMSGirl2to19[221] =
            LMS(-0.806, 21.3341, 0.14377)
        mapLMSGirl2to19[222] =
            LMS(-0.798, 21.348, 0.14386)
        mapLMSGirl2to19[223] =
            LMS(-0.7899, 21.3617, 0.14396)
        mapLMSGirl2to19[224] =
            LMS(-0.7819, 21.3752, 0.14405)
        mapLMSGirl2to19[225] =
            LMS(-0.7738, 21.3884, 0.14414)
        mapLMSGirl2to19[226] =
            LMS(-0.7658, 21.4014, 0.14423)
        mapLMSGirl2to19[227] =
            LMS(-0.7577, 21.4143, 0.14432)
        mapLMSGirl2to19[228] =
            LMS(-0.7496, 21.4269, 0.14441)
    }

    class LMS(var l: Double, var m: Double, var s: Double)
}