package pl.karolpietrow.kp1

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import pl.karolpietrow.kp1.ui.theme.KP1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KP1Theme {
                ToastDrawer();
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
fun ToastDrawer(modifier: Modifier = Modifier) {
    val context = LocalContext.current
    val texts = listOf("One", "Two", "Three", "Four", "Five")
    var inputText by remember { mutableStateOf("") }
    var displayedText by remember { mutableStateOf("Domyślny tekst") }

    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Moja aplikacja 1",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
        )
        Text(
            text = "Karol P :)",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(30.dp))
        Column(
//        modifier = modifier,
            modifier = Modifier
                .fillMaxSize(),
//            .padding(50.dp),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            for (item in texts) {
                Text(text = item, modifier = modifier)
            }
            Column (
                modifier = Modifier,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Row(
                    modifier = modifier,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    TextField(
                        value = inputText,
                        onValueChange = { inputText = it},
                        label = { Text("Wpisz tekst")},
                        modifier = Modifier.weight(1f)
                    )

                    Button(
                        modifier = modifier,

                        onClick = {
                            Toast.makeText(context, inputText, Toast.LENGTH_SHORT).show()
                            displayedText = inputText
                        }
                    ) {
                        Text("Show text")            }
                }
                Text(text = displayedText,modifier=modifier)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MyPreview() {
    ToastDrawer();
}