package com.example.criptotrackerapp.model
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun AssetRow() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()
    ) {
        Icon(
            imageVector = Icons.Filled.AccountCircle,
            contentDescription = null,
            modifier = Modifier.padding(horizontal = 8.dp)
        )
        Column {
            Text(text = "Bitcoin")
            Text(text = "BTC")
        }
        Spacer(modifier = Modifier.weight(1f))
        Text(
            text = "$65000",
            fontSize = 16.sp,
            modifier = Modifier.padding(horizontal = 8.dp)
        )
        Text(
            text = "5.75",
            fontSize = 14.sp,
            modifier = Modifier.padding(horizontal = 8.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun AssetRowPreview() {
    Column(modifier = Modifier.fillMaxSize()) {
        AssetRow()
        Divider()
        AssetRow()
        Divider()
    }
}
