package com.example.qiwicomposescreen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.SnackbarDefaults.backgroundColor
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.qiwicomposescreen.ui.theme.Purple200
import com.example.qiwicomposescreen.ui.theme.QiwiComposeScreenTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            QiwiComposeScreenTheme {
                // A surface container using the 'background' color from the theme
                    searchBar()
                    BalanceCard("")
                }
            }
        }
    }

@Composable
fun searchBar (modifier: Modifier = Modifier) {
    Row() {

        TextField(
            value = "",
            onValueChange = {},
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = null
                )
            },
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = MaterialTheme.colors.surface
            ),
            placeholder = {
                Text(stringResource(R.string.placeholder_search))
            },
            modifier = modifier
                .fillMaxWidth(0.9f)
                .padding(8.dp)
                .heightIn(min = 56.dp),
            shape = RoundedCornerShape(4.dp)
            )
        Box(modifier = Modifier.fillMaxWidth(0.1f)) {
            Image(imageVector = Icons.Default.Notifications, contentDescription = null )
        }
    }
}

@Composable
fun BalanceCard(name: String) {
    //------------------------ Карточка --------------------------------
    Card(
        modifier = Modifier
//            .width(IntrinsicSize.Max)
            .fillMaxWidth()
            .padding(horizontal = 10.dp, vertical = 80.dp)
            .clickable { },
        elevation = 5.dp,
        backgroundColor = MaterialTheme.colors.primary
    ) {
        Column(
            modifier = Modifier.padding(15.dp)
        )
        {
            Text(
                text = "0 рублей",
                style = MaterialTheme.typography.h5,
                modifier = Modifier
                    .align(CenterHorizontally)
                    .padding(vertical = 18.dp)
            )
            //------------------------ Кнопка --------------------------------
            Button(
                onClick = { /* Do something! */ },
                colors = ButtonDefaults.textButtonColors(
                    backgroundColor = MaterialTheme.colors.background
                ),
                modifier = Modifier
                    .align(CenterHorizontally)
                    .fillMaxWidth()
                    .padding(horizontal = 15.dp)
            ) {
                Text(
                    text = "Пополнить кошелек",
                    style = MaterialTheme.typography.button
                )
            }
        }
    }
}

    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview() {
        QiwiComposeScreenTheme {
            BalanceCard("")
        }
    }

@Preview (showBackground = true)
@Composable
fun SearchPreview() {
    QiwiComposeScreenTheme {
        searchBar()
    }
}