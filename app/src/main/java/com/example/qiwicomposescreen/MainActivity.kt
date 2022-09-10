package com.example.qiwicomposescreen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.qiwicomposescreen.ui.theme.QiwiComposeScreenTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            QiwiComposeScreenTheme {
                ProductScreen()
            }
            }
        }
    }

@Composable
fun ProductScreen () {
    MaterialTheme.colors.background
    LazyColumn(modifier = Modifier
        .fillMaxSize()
        .padding(horizontal = 10.dp, vertical = 20.dp)
    ){
        item { SearchBar() }
        item { BalanceCard() }
        item { BodyElement() }

    }

}

@Composable
fun SearchBar () {
    //------------------------ Поиск --------------------------------
    Row(
        modifier = Modifier.padding(10.dp),
        verticalAlignment = CenterVertically
    ) {
        val textState = remember { mutableStateOf(TextFieldValue()) }
        TextField(
            value = textState.value,
            onValueChange = { textState.value = it },
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
            shape = RoundedCornerShape(4.dp)
        )
        Icon(
            imageVector = Icons.Default.Notifications,
            contentDescription = null,
            modifier = Modifier.padding(horizontal = 12.dp)
        )
    }
}


@Composable
fun BalanceCard() {
    //------------------------ Карточка --------------------------------
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 20.dp),
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
                    .padding(horizontal = 30.dp)
                    .height(40.dp)
            ) {
                Text(
                    text = "Пополнить кошелек",
                    style = MaterialTheme.typography.body1
                )
            }
        }
    }
}

    @Composable
    fun BodyElement () {
        Text(
            text = stringResource(R.string.favourite_header),
            style = MaterialTheme.typography.h5,
        )
        Row (
            modifier = Modifier.padding(vertical = 20.dp),
            verticalAlignment = CenterVertically
        ) {
            Image(
                painter = painterResource(R.drawable.megafon_logo),
                contentDescription = null,
                Modifier
                    .width(50.dp)
            )
            Text(
                text = stringResource(R.string.favourite_pay),
                style = MaterialTheme.typography.body1,
                modifier = Modifier.padding(horizontal = 10.dp)

            )
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun MainScreenPreview() {
        QiwiComposeScreenTheme {
            ProductScreen()
        }
    }


