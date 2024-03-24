import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalInspectionMode
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.annotation.ExperimentalCoilApi
import coil.compose.AsyncImage

data class Asset(
    val id: String,
    val name: String,
    val symbol: String,
    val price: Double,
    val percentage: Double
)

@OptIn(ExperimentalCoilApi::class)
@Composable
fun AssetsList() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.DarkGray)
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
        Divider(color = Color.White)
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

@Composable
fun AssetRow(asset: Asset) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()
    ) {
        if (LocalInspectionMode.current) {
            Icon(
                imageVector = Icons.Filled.AccountCircle,
                contentDescription = null,
                tint = Color.White,
                modifier = Modifier.padding(horizontal = 8.dp)
            )
        } else {
            AsyncImage(
                model = "https://assets.coincap.io/assets/icons/${asset.symbol.lowercase()}@2x.png",
                contentDescription = null,
                modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .size(30.dp)
            )
        }
        Column {
            Text(
                text = asset.name,
                color = Color.White,
                modifier = Modifier.padding(bottom = 4.dp)
            )
            Text(
                text = asset.symbol,
                color = Color.White,
                modifier = Modifier.padding(bottom = 4.dp)
            )
        }
        Spacer(modifier = Modifier.weight(1f))
        Text(
            text = "$${asset.price}",
            color = Color.White,
            fontSize = 16.sp,
            modifier = Modifier.padding(horizontal = 8.dp)
        )
        val color = if (asset.percentage >= 0) Color.Green else Color.Red
        Text(
            text = "${asset.percentage}%",
            color = color,
            fontSize = 14.sp,
            modifier = Modifier.padding(horizontal = 8.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun AssetRowPreview() {
    AssetsList()
}
