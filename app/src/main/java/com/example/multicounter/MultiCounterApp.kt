package com.example.multicounter

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun MultiCounterApp() {
    var counters by remember { mutableStateOf(listOf(0)) }

    Column {
        LazyColumn(modifier = Modifier.weight(1f)) {
            itemsIndexed(counters) { index, count ->
                CounterItem(
                    name = "Counter_${index + 1}",
                    count = count,
                    onIncrement = {
                        counters = counters.toMutableList().apply {
                            this[index] = this[index] + 1
                        }
                    },
                    onDecrement = {
                        counters = counters.toMutableList().apply {
                            this[index] = this[index] - 1
                        }
                    },
                    onRemove = {
                        counters = counters.toMutableList().apply {
                            removeAt(index)
                        }
                    }
                )
            }
        }

        Button(
            onClick = { counters = counters + 0 },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text("Add Counter")
        }
    }
}
