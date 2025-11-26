package com.example.profilapp_nimnama

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.profilapp_nimnama.ui.theme.ProfilAppNIMNamaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProfilAppNIMNamaTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ProfilScreen()
                }
            }
        }
    }
}

@Composable
fun ProfilScreen() {
    // Background dengan warna gradient-like
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF5F5F5)) // Abu-abu terang
            .padding(24.dp)
    ) {
        // Bagian Profil dengan background putih
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)
                .padding(32.dp)
        ) {
            // Foto Profil
            Image(
                painter = painterResource(id = R.drawable.profil),
                contentDescription = "Foto Profil",
                modifier = Modifier
                    .size(150.dp)
                    .clip(CircleShape)
            )

            Spacer(modifier = Modifier.height(24.dp))

            // Nama Lengkap
            Text(
                text = "SILVANA ARAYUNDA MARBUN",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF333333),
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )


            Spacer(modifier = Modifier.height(8.dp))

            // NIM
            Text(
                text = "NIM: 235150201111076",
                fontSize = 16.sp,
                color = Color(0xFF666666)
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Deskripsi Singkat
            Text(
                text = "Mahasiswa Teknik Informatika",
                fontSize = 14.sp,
                color = Color(0xFF888888)
            )

            Spacer(modifier = Modifier.height(24.dp))

            // Tombol Follow/Unfollow
            FollowButton()
        }
    }
}

@Composable
fun FollowButton() {
    // State untuk menyimpan status follow
    var isFollowed by remember { mutableStateOf(false) }

    Button(
        onClick = {
            isFollowed = !isFollowed
        },
        colors = ButtonDefaults.buttonColors(
            containerColor = if (isFollowed) Color(0xFFE0E0E0) else Color(0xFF2196F3)
        ),
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp)
    ) {
        Text(
            text = if (isFollowed) "Unfollow" else "Follow",
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = if (isFollowed) Color(0xFF666666) else Color.White
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ProfilScreenPreview() {
    ProfilAppNIMNamaTheme {
        ProfilScreen()
    }
}
