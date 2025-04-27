package com.example.weleapai.features.portfolioSelectionProcess.presentation

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import com.example.weleapai.features.portfolioSelectionProcess.domain.PersonalDetailsValidator
import com.example.weleapai.ui.theme.DarkBlue


@Composable
fun PersonalDetailsScreen(navController: NavHostController) {
    var fullName by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var phoneNumber by remember { mutableStateOf("") }
    var dob by remember { mutableStateOf("") }
    var address by remember { mutableStateOf("") }
    var investmentGoals by remember { mutableStateOf("") }
    var fullNameError by remember { mutableStateOf<String?>(null) }
    var emailError by remember { mutableStateOf<String?>(null) }
    var phoneNumberError by remember { mutableStateOf<String?>(null) }
    var dobError by remember { mutableStateOf<String?>(null) }
    var addressError by remember { mutableStateOf<String?>(null) }
    val context = LocalContext.current

    val formIsValid = fullName.isNotBlank() &&
            email.isNotBlank() &&
            phoneNumber.isNotBlank() &&
            dob.isNotBlank() &&
            address.isNotBlank() &&
            fullNameError == null &&
            emailError == null &&
            phoneNumberError == null &&
            dobError == null &&
            addressError == null

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp, vertical = 14.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Personal Details",
            style = MaterialTheme.typography.headlineSmall.copy(
                fontWeight = FontWeight.Bold,
                fontSize = 22.sp
            ),
            modifier = Modifier.padding(bottom = 8.dp)
        )
        Text(
            text = "Please fill in your details to personalize your investment experience.",
            style = MaterialTheme.typography.bodyMedium,
            color = Color.Gray,
            textAlign = TextAlign.Center,
            fontSize = 16.sp,
            modifier = Modifier.padding(bottom = 12.dp)
        )

        InputField(
            value = fullName,
            onValueChange = {
                fullName = it
                fullNameError = null
            },
            label = "Full Name",
            leadingIcon = {
                Icon(
                    Icons.Default.Person, contentDescription = null, tint = DarkBlue
                )
            },
            errorMessage = fullNameError
        )

        InputField(
            value = email,
            onValueChange = {
                email = it
                emailError = null

            },
            label = "Email",
            leadingIcon = { Icon(Icons.Default.Email, contentDescription = null, tint = DarkBlue) },
            errorMessage = emailError,
            keyboardType = KeyboardType.Email
        )

        InputField(
            value = phoneNumber,
            onValueChange = {
                phoneNumber = it
                phoneNumberError = null
            },
            label = "Phone Number",
            leadingIcon = { Icon(Icons.Default.Phone, contentDescription = null, tint = DarkBlue) },
            errorMessage = phoneNumberError,
            keyboardType = KeyboardType.Phone
        )

        InputField(
            value = dob,
            onValueChange = {
                dob = it
                dobError = null
            },
            label = "Date of Birth (dd-mm-yyyy)",
            leadingIcon = {
                Icon(
                    Icons.Default.CalendarToday,
                    contentDescription = null,
                    tint = DarkBlue
                )
            },
            errorMessage = dobError,
        )

        InputField(
            value = address,
            onValueChange = {
                address = it
                addressError = null
            },
            label = "Address",
            leadingIcon = {
                Icon(
                    Icons.Default.LocationOn,
                    contentDescription = null,
                    tint = DarkBlue
                )
            },
            errorMessage = addressError
        )

        InputField(
            value = investmentGoals,
            onValueChange = {
                investmentGoals = it
            },
            label = "Investment Goals (Optional)",
            leadingIcon = { Icon(Icons.Default.Flag, contentDescription = null, tint = DarkBlue) }
        )

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = {
                val fullNameResult = PersonalDetailsValidator.validateFullName(fullName)
                val emailResult = PersonalDetailsValidator.validateEmail(email)
                val phoneResult = PersonalDetailsValidator.validatePhoneNumber(phoneNumber)
                val dobResult = PersonalDetailsValidator.validateDateOfBirth(dob)
                val addressResult = PersonalDetailsValidator.validateAddress(address)

                fullNameError = fullNameResult.errorMessage
                emailError = emailResult.errorMessage
                phoneNumberError = phoneResult.errorMessage
                dobError = dobResult.errorMessage
                addressError = addressResult.errorMessage

                val hasError =
                    listOf(fullNameResult, emailResult, phoneResult, dobResult, addressResult)
                        .any { !it.successful }

                if (!hasError) {
                    // Proceed to next screen
                }
            },
            enabled = formIsValid,
            colors = ButtonDefaults.buttonColors(
                containerColor = if (formIsValid) DarkBlue else Color.Gray
            ),
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
        ) {
            Text(text = "Next: Create Portfolio", fontSize = 16.sp)
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Your data is securely stored and used only to enhance your investment experience with weLEAP.AI.",
            style = MaterialTheme.typography.bodySmall,
            color = Color.Gray,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(horizontal = 16.dp)
        )

        Spacer(modifier = Modifier.height(8.dp))

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InputField(
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    leadingIcon: @Composable (() -> Unit)? = null,
    keyboardType: KeyboardType = KeyboardType.Text,
    errorMessage: String? = null
) {
    Column(modifier = Modifier.fillMaxWidth()) {
        OutlinedTextField(
            value = value,
            onValueChange = onValueChange,
            label = { Text(label) },
            leadingIcon = leadingIcon,
            keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
            isError = errorMessage != null,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 4.dp),
            shape = RoundedCornerShape(8.dp),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                containerColor = Color(0xFFF5F5F5),
                focusedBorderColor = if (errorMessage != null) Color.Red else Color(0xFF2563EB),
                unfocusedBorderColor = if (errorMessage != null) Color.Red else Color.LightGray
            )
        )
        if (errorMessage != null) {
            Text(
                text = errorMessage,
                color = Color.Red,
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier.padding(start = 16.dp, top = 2.dp)
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
private fun PreviewFeatureCard() {
    PersonalDetailsScreen(NavHostController(LocalContext.current))
}

