package com.itbproject.savethecat.ui.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.itbproject.savethecat.R
import com.itbproject.savethecat.ui.theme.LightBrown

val Rowdies = FontFamily(
    Font(R.font.rowdies_regular),
    Font(R.font.rowdies_regular, weight = FontWeight.Bold)
)

// Set of Material typography styles to start with
val Typography = Typography(
    body1 = TextStyle(
        fontFamily = Rowdies,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp
    ),
    h3 = TextStyle(
        fontFamily = Rowdies,
        fontWeight = FontWeight.Bold,
        fontSize = 20.sp
    )
    /* Other default text styles to override
    button = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.W500,
        fontSize = 14.sp
    ),
    caption = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    )
    */
)