package com.baharudin.nutrition.presentation.onbarding

import androidx.annotation.DrawableRes
import com.baharudin.nutrition.R

sealed class OnboardingPage(
    @DrawableRes
    val image: Int,
    val title: String,
    val description: String
) {
    object FirstPage : OnboardingPage(
        image = R.drawable.page_1,
        title = "Eat Healtly",
        description = "Maintaining good health should be the primary focus of everyone."
    )

    object SecondPage : OnboardingPage(
        image = R.drawable.page_2,
        title = "Healtly Recipe",
        description = "Maintaining good health should be the primary focus of everyone."
    )

    object ThirdPage : OnboardingPage(
        image = R.drawable.page_3,
        title = "Track Your Health",
        description = "Maintaining good health should be the primary focus of everyone."
    )
}