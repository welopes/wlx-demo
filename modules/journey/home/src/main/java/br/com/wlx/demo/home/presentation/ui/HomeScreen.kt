package br.com.wlx.demo.home.presentation.ui


import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.ArrowDropUp
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.StarBorder
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.DividerDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Slider
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.wlx.demo.home.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen() {
    val scrollState = rememberScrollState()
    var text by remember { mutableStateOf("") }
    var checked by remember { mutableStateOf(false) }
    var switchOn by remember { mutableStateOf(false) }
    var selectedOption by remember { mutableStateOf("Option 1") }
    val options = listOf("Option 1", "Option 2", "Option 3")
    var sliderPosition by remember { mutableStateOf(0.5f) }
    var rating by remember { mutableStateOf(3) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text("Welcome to the Home Screen!", style = MaterialTheme.typography.headlineLarge)

        Text("Showcasing many Compose UI components.", style = MaterialTheme.typography.bodyLarge)

        Card(
            modifier = Modifier.fillMaxWidth(),
            elevation = CardDefaults.cardElevation(8.dp)
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text("Card Title", style = MaterialTheme.typography.headlineSmall)
                Text(
                    "This is a card with some example text.",
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }

        Row(
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            Button(onClick = { /* primary action */ }, modifier = Modifier.weight(1f)) {
                Text("Primary")
            }
            OutlinedButton(onClick = { /* secondary action */ }, modifier = Modifier.weight(1f)) {
                Text("Secondary")
            }
        }

        OutlinedTextField(
            value = text,
            onValueChange = { text = it },
            label = { Text("Input Text") },
            modifier = Modifier.fillMaxWidth()
        )

        Row(verticalAlignment = Alignment.CenterVertically) {
            Checkbox(checked = checked, onCheckedChange = { checked = it })
            Spacer(modifier = Modifier.width(8.dp))
            Text("Accept Terms")
        }

        Row(verticalAlignment = Alignment.CenterVertically) {
            Switch(checked = switchOn, onCheckedChange = { switchOn = it })
            Spacer(modifier = Modifier.width(8.dp))
            Text("Enable Notifications")
        }

        var expanded by remember { mutableStateOf(false) }
        var selectedOption by remember { mutableStateOf("Option 1") }
        val options = listOf("Option 1", "Option 2", "Option 3")

        Box(modifier = Modifier.fillMaxWidth()) {
            OutlinedTextField(
                value = selectedOption,
                onValueChange = {},
                label = { Text("Select an option") },
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { expanded = true },
                readOnly = true,
                trailingIcon = {
                    Icon(
                        imageVector = if (expanded) Icons.Default.ArrowDropUp else Icons.Default.ArrowDropDown,
                        contentDescription = null
                    )
                },
                enabled = false // evita abrir o teclado
            )

            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false },
                modifier = Modifier.fillMaxWidth()
            ) {
                options.forEach { option ->
                    DropdownMenuItem(onClick = {
                        selectedOption = option
                        expanded = false
                    }, text = { Text(option) })
                }
            }
        }

        // Slider
        Column {
            Text(
                "Volume: ${(sliderPosition * 100).toInt()}%",
                style = MaterialTheme.typography.bodyMedium
            )
            Slider(value = sliderPosition, onValueChange = { sliderPosition = it })
        }

        // Image example
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_foreground),
            contentDescription = "Sample Image",
            modifier = Modifier
                .fillMaxWidth()
                .height(180.dp)
                .clip(RoundedCornerShape(8.dp)),
            contentScale = ContentScale.Crop
        )

        // LazyRow horizontal list of cards
        Text("Featured Items", style = MaterialTheme.typography.headlineSmall)
        LazyRow(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
            items(listOf("One", "Two", "Three", "Four", "Five")) { item ->
                Card(
                    modifier = Modifier.size(width = 140.dp, height = 120.dp),
                    elevation = CardDefaults.cardElevation(6.dp)
                ) {
                    Box(contentAlignment = Alignment.Center) {
                        Text(item, style = MaterialTheme.typography.headlineMedium)
                    }
                }
            }
        }

        // Rating Bar (simulado com Row de Icons)
        Text("Rate us:", style = MaterialTheme.typography.bodyLarge)
        Row {
            repeat(5) { index ->
                Icon(
                    imageVector = if (index < rating) Icons.Default.Star else Icons.Default.StarBorder,
                    contentDescription = null,
                    modifier = Modifier
                        .size(32.dp)
                        .clickable { rating = index + 1 },
                    tint = MaterialTheme.colorScheme.primary
                )
            }
        }

        HorizontalDivider(Modifier, DividerDefaults.Thickness, DividerDefaults.color)

        // Footer with button and text
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("Thank you for visiting!", style = MaterialTheme.typography.bodyMedium)
            TextButton(onClick = { /* contact action */ }) {
                Text("Contact Us")
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}