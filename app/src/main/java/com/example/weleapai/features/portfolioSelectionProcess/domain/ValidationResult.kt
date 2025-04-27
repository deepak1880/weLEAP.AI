package com.example.weleapai.features.portfolioSelectionProcess.domain

data class ValidationResult(
    val successful: Boolean,
    val errorMessage: String? = null
)
