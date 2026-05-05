package com.ppj.calculator.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.ppj.calculator.viewmodel.CalculatorViewModel

@Composable
fun CalculatorScreen(vm: CalculatorViewModel = viewModel()) {

    val state = vm.state

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ) {

        Text(
            text = state.display,
            fontSize = 48.sp,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.End
        )

        Column {
            Row {
                Button(onClick = { vm.onNumberClick(7) }, modifier = Modifier.weight(1f)) { Text("7") }
                Button(onClick = { vm.onNumberClick(8) }, modifier = Modifier.weight(1f)) { Text("8") }
                Button(onClick = { vm.onNumberClick(9) }, modifier = Modifier.weight(1f)) { Text("9") }
                Button(onClick = { vm.onOperatorClick('/') }, modifier = Modifier.weight(1f)) { Text("/") }
            }

            Row {
                Button(onClick = { vm.onNumberClick(4) }, modifier = Modifier.weight(1f)) { Text("4") }
                Button(onClick = { vm.onNumberClick(5) }, modifier = Modifier.weight(1f)) { Text("5") }
                Button(onClick = { vm.onNumberClick(6) }, modifier = Modifier.weight(1f)) { Text("6") }
                Button(onClick = { vm.onOperatorClick('*') }, modifier = Modifier.weight(1f)) { Text("*") }
            }

            Row {
                Button(onClick = { vm.onNumberClick(1) }, modifier = Modifier.weight(1f)) { Text("1") }
                Button(onClick = { vm.onNumberClick(2) }, modifier = Modifier.weight(1f)) { Text("2") }
                Button(onClick = { vm.onNumberClick(3) }, modifier = Modifier.weight(1f)) { Text("3") }
                Button(onClick = { vm.onOperatorClick('-') }, modifier = Modifier.weight(1f)) { Text("-") }
            }

            Row {
                Button(onClick = { vm.onNumberClick(0) }, modifier = Modifier.weight(1f)) { Text("0") }
                Button(onClick = { vm.onClear() }, modifier = Modifier.weight(1f)) { Text("C") }
                Button(onClick = { vm.onEquals() }, modifier = Modifier.weight(1f)) { Text("=") }
                Button(onClick = { vm.onOperatorClick('+') }, modifier = Modifier.weight(1f)) { Text("+") }
            }
        }
    }
}