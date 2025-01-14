package fi.oamk.walkthroughbodymass



import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.text.DecimalFormat

//import java.text.DecimalFormat


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Theme {
                Scaffold(
                    modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Bmi(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}
//
//@Composable
//fun Bmi(modifier: Modifier = Modifier) {
//    var heightInput: String by remember { mutableStateOf("") }
//    var weightInput: String by remember { mutableStateOf("") }
//    val height = heightInput.toFloatOrNull() ?: 0.0f
//    val weight = weightInput.toIntOrNull() ?: 0
//    val formatter = DecimalFormat("0.00")
//    val bmi = if (weight > 0 && height > 0) formatter.format(weight / (height *
//            height)) else 0.0f
//    Column {
//        Text (
//            text = "Body mass index",
//            fontSize = 24.sp,
//            color = MaterialTheme.colorScheme.primary,
//            textAlign = TextAlign.Center,
//            modifier = modifier.fillMaxWidth().padding(vertical = 16.dp)
//        )
//        OutlinedTextField(
//            value = heightInput,
//            onValueChange = {heightInput = it.replace(',','.')},
//            label = {Text("Height")},
//            singleLine = true,
//            keyboardOptions = KeyboardOptions(
//                keyboardType = KeyboardType.Number),
//            modifier = Modifier.fillMaxWidth().padding(start = 8.dp, end = 8.dp)
//        )
//        OutlinedTextField(
//            value = weightInput,
//            onValueChange = {weightInput = it.replace(',','.')},
//            label = {Text("Weight")},
//            singleLine = true,
//            keyboardOptions = KeyboardOptions(
//                keyboardType = KeyboardType.Number),
//            modifier = Modifier.fillMaxWidth().padding(start = 8.dp, end = 8.dp)
//        )
//        Text(
//            text = "Body mass index is $bmi",
//            modifier = Modifier.fillMaxWidth().padding(start = 16.dp,top = 16.dp)
//        )
//
//    }
//}

@Composable
fun Bmi(modifier: Modifier = Modifier) {
    var heightInput: String by remember { mutableStateOf("") }
    var weightInput: String by remember { mutableStateOf("") }

    val height = heightInput.toFloatOrNull() ?: 0.0f
    val weight = weightInput.toIntOrNull() ?: 0
    val formatter = DecimalFormat("0.00")
    val bmi = if (weight > 0 && height > 0) formatter.format(weight / (height * height)) else 0.0f

    Column {
        Text(
            text = "Body mass index",
            fontSize = 24.sp,
            color = MaterialTheme.colorScheme.primary,
            textAlign = TextAlign.Center,
            modifier = modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp)
        )
        OutlinedTextField(
            value = heightInput,
            onValueChange = { heightInput = it.replace(',', '.') },
            label = { Text("Height") },
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 8.dp, end = 8.dp)
        )
        OutlinedTextField(
            value = weightInput,
            onValueChange = { weightInput = it.replace(',', '.') },
            label = { Text("Weight") },
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 8.dp, end = 8.dp)
        )
        Text(
            text = stringResource(R.string.body_mass_index_is) + bmi,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, top = 16.dp)
        )
    }
}

@Composable
fun Theme(content: @Composable () -> Unit) {
    // Theme logic here
    content()
}



@Preview(showBackground = true)
@Composable
fun Preview() {
    Theme() {
        Bmi()
    }
}