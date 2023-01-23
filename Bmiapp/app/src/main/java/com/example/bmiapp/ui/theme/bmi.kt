package com.example.bmiapp.ui.theme

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.stringResource
import com.example.bmiapp.R


@Composable
fun Bmi(){
    var heightInput: String by remember { mutableStateOf("") }
    var weightInput : String by remember { mutableStateOf("") }
    val height = heightInput.toFloatOrNull() ?:0.0f
    val weight = weightInput.toIntOrNull() ?: 0
    val bmi = if (weight > 0  && height >0) weight / (height * height) else 0.0

    Column(){
        Text(
            text= "Body Mass Index",
            fontSize = 24.sp,
            color = MaterialTheme.colors.primary,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp, bottom = 16.dp)
        )
    OutlinedTextField(
        value = heightInput ,
        onValueChange = {heightInput = it.replace(',','.')},
        label = { Text(text = "Height")},
        singleLine = true,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = weightInput ,
            onValueChange = {weightInput = it.replace(',','.')},
            label = { Text(text = "Weight")},
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )
        Text(text = stringResource(R.string.result, String.format("%.2f",bmi).replace(',','.')))
    }
}