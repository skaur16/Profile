package com.example.profile2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.profile2.ui.theme.Profile2Theme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Profile2Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    var flag= remember{mutableStateOf(0)}
                    var finalname = remember{ mutableStateOf(" ") }
                    var finalage = remember{ mutableStateOf(" ") }
                    var finalnum = remember{ mutableStateOf(" ") }
                    var name =remember {mutableStateOf("")}
                    var age =remember {mutableStateOf("")}
                    var num =remember {mutableStateOf("")}

                    Column(
                        modifier=Modifier.fillMaxSize()
                    )
                    {

                        Row(
                            horizontalArrangement = Arrangement.Center
                        )
                        {
                            TopAppBar(
                                title = { Text(text = "Profile") },
                                colors = TopAppBarDefaults .smallTopAppBarColors(
                                    containerColor = Color.LightGray
                                )

                            )
                        }


                        Row(
                            modifier=Modifier.height(180.dp),
                            horizontalArrangement = Arrangement.SpaceEvenly
                        )
                        {
                            Column(
                                modifier=Modifier.fillMaxHeight(),
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.Center
                                // modifier= Modifier.background(color = Color.Red)
                            )
                            {
                                Image(
                                    painter = painterResource(id = R.drawable.ic_launcher_background ),
                                    contentDescription = "Hello there"
                                )
                            }


                            Column(
                                verticalArrangement = Arrangement.SpaceEvenly,
                                modifier=Modifier.wrapContentSize()

                            )

                            {

                                Row(modifier=Modifier.height(60.dp))
                                {

                                    TextField(value = name.value,
                                        onValueChange = {
                                            name.value = it
                                            finalname.value=name.value
                                        },label = {Text(text="Name")}
                                    )


                                }
                                Row(modifier=Modifier.height(60.dp))
                                {

                                    TextField(value = age.value,
                                        onValueChange = {
                                            age.value = it
                                            finalage.value = age.value
                                        }, label = {Text(text="Age")}
                                    )
                                }
                                Row(modifier=Modifier.height(60.dp))
                                {

                                    TextField(value = num.value,
                                        onValueChange = {
                                            num.value = it
                                            finalnum.value = num.value
                                        },
                                        label = {Text(text="Number")}
                                    )
                                }

                            }

                        }

                        Spacer(modifier=Modifier.height(20.dp))

                        Row(
                            modifier=Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.Center
                        )
                        {
                            Button(onClick = { flag.value=1 }) {
                                Text(text="Save")
                            }
                        }
                        Spacer(modifier=Modifier.height(20.dp))

                        if(flag.value==2){
                            flag.value=0
                            name.value=""
                            age.value=""
                            num.value=""
                            finalname.value=""
                            finalage.value=""
                            finalnum.value=""
                        }

                        if(flag.value==1) {
                            Column(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.SpaceEvenly
                            ) {
                                Row() {
                                    Text(text = "Name: ")
                                    Text(text = finalname.value)
                                }
                                Row() {
                                    Text(text = "Age: ")
                                    Text(text = finalage.value)
                                }
                                Row() {
                                    Text(text = "Number: ")
                                    Text(text = finalnum.value)
                                }

                                Spacer(modifier=Modifier.height(20.dp))

                                Row() {
                                    Button(onClick = { flag.value = 2 }) {
                                        Text(text = "Reset")
                                    }
                                }
                            }

                        }







                    }
                }
            }
        }
    }
}
