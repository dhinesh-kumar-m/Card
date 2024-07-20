package com.example.bussinesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.bussinesscard.ui.theme.BussinessCardTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.ui.Alignment
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.foundation.Image
import androidx.compose.ui.unit.dp
import androidx.compose.ui.res.painterResource
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.fillMaxWidth


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BussinessCardTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    BussinessCard(imageResId = R.drawable.android_logo ,name = "Dhinesh",title="Full Stack Developer",phone="+917871759569",email="dhineshkumar@testpress.in",instagram="@dhineshkumar")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Composable
fun ProfileSection(imageResId: Int, fullName: String, jobTitle: String) {
    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = imageResId),
            contentDescription = "Profile Image of $fullName",
            modifier = Modifier.size(128.dp) // Adjust the size as needed
        )
        Text(text = fullName, style = MaterialTheme.typography.titleLarge)
        Text(text = jobTitle, style = MaterialTheme.typography.bodyMedium)
    }
}

@Composable
fun ContactDetails(phone: String, email: String, instagram: String) {
    Column(
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalAlignment = Alignment.Start,
        modifier = Modifier.fillMaxWidth()
    ) {
        ContactDetailRow(iconRes = R.drawable.ic_phone, detail = phone)
        ContactDetailRow(iconRes = R.drawable.ic_email, detail = email)
        ContactDetailRow(iconRes = R.drawable.ic_instagram, detail = instagram)
    }
}

@Composable
fun ContactDetailRow(iconRes: Int, detail: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier.padding(vertical = 4.dp)
    ) {
        Image(
            painter = painterResource(id = iconRes),
            contentDescription = null, // Decorative image
            modifier = Modifier.size(24.dp)
        )
        Text(text = detail, style = MaterialTheme.typography.bodyMedium)
    }
}

@Composable
fun BussinessCard(imageResId:Int,name:String,title:String,phone:String,email:String,instagram:String){
    ProfileSection(imageResId,name,title)
    ContactDetails(phone,email,instagram)

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BussinessCardTheme {
        BussinessCard(imageResId = R.drawable.android_logo ,name = "Dhinesh",title="Full Stack Developer",phone="+917871759569",email="dhineshkumar@testpress.in",instagram="@dhineshkumar")
    }
}