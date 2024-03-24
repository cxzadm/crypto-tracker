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

data class Asset(
    val id: String,
    val name: String,
    val symbol: String,
    val price: Double,
    val percentage: Double
)

@Composable
fun AssetRow(asset: Asset) {
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
            Text(text = asset.name)
            Text(text = asset.symbol)
        }
        Spacer(modifier = Modifier.weight(1f))
        Text(
            text = "$${asset.price}",
            fontSize = 16.sp,
            modifier = Modifier.padding(horizontal = 8.dp)
        )
        Text(
            text = "${asset.percentage}%",
            fontSize = 14.sp,
            modifier = Modifier.padding(horizontal = 8.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun AssetRowPreview() {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        AssetRow(
            Asset(
                id = "bitcoin",
                name = "Bitcoin",
                symbol = "BTC",
                price = 65000.00,
                percentage = 5.75
            )
        )
        Divider()
        AssetRow(
            Asset(
                id = "ethereum",
                name = "Ethereum",
                symbol = "ETH",
                price = 3500.05,
                percentage = -1.8
            )
        )
    }
}

