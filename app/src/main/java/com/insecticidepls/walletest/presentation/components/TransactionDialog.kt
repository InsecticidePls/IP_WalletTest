package com.insecticidepls.walletest.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.selection.LocalTextSelectionColors
import androidx.compose.foundation.text.selection.TextSelectionColors
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.insecticidepls.walletest.ui.theme.orange
import com.insecticidepls.walletest.ui.theme.white

@Composable
fun TransactionDialog (
    onDismiss: () -> Unit,
    onConfirm: () -> Unit,
    amount: () -> String,
    isButtonEnabled: () -> Boolean,
    onAmountChange: (String) -> Unit,
    desc: String,
    modifier: Modifier = Modifier
){
    //Reminder: Find something to apply here
    modifier.padding()

    Dialog(
        onDismissRequest = {
            onDismiss()
        }
    ){
        Card(
            elevation = 5.dp,
            modifier = Modifier
                .fillMaxWidth()
        ){
            CompositionLocalProvider(
                LocalTextSelectionColors provides TextSelectionColors(
                    handleColor = orange,
                    backgroundColor = Color.Transparent
                )
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(15.dp)
                    ,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(10.dp)
                ){
                    OutlinedTextField(
                        value = amount(),
                        onValueChange = {
                            onAmountChange(it)
                        },
                        textStyle = MaterialTheme.typography.body1,
                        label = {
                            Text(desc)
                        },
                        colors = TextFieldDefaults.textFieldColors(
                            cursorColor = orange,
                            focusedIndicatorColor = orange,
                            focusedLabelColor = orange
                        ),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone)
                    )
                    Button(
                        onClick = {
                            onConfirm()
                        },
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = orange,
                            contentColor = white
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(10.dp),
                        enabled = isButtonEnabled()
                    ) {
                        Icon(
                            Icons.Filled.Check,
                            contentDescription = "Check",
                            modifier = Modifier.size(ButtonDefaults.IconSize)
                        )
                        Spacer(Modifier.size(ButtonDefaults.IconSpacing))
                        Text("CONFIRM")
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TransactionDialogPreview() {
    TransactionDialog(
        onDismiss = { },
        amount = { "23.21" },
        onAmountChange = {

        },
        desc = "Deposit",
        onConfirm = {

        },
        isButtonEnabled = {
            true
        }
    )
}
