package com.example.textfieldjetpack

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun VerticalScreen(){
    Column( modifier= Modifier
        .fillMaxWidth()
        .wrapContentHeight()
        .padding(18.dp),
        verticalArrangement=Arrangement.Center,){
        TextComponent(
            value="Hello there!",
            colorValue = Color.Black,
            size = 24.sp,
            fontWeightValue = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(10.dp))

        TextFieldComponent()

        Spacer(modifier = Modifier.height(40.dp))

        SimpleButton()

        Spacer(modifier = Modifier.height(40.dp))


        ImageComponent()

    }
}


@Composable
fun TextComponent(value: String,
                  size:TextUnit=18.sp,
                  colorValue: Color=Color.Magenta,
                  fontWeightValue:FontWeight=FontWeight.Normal,
                  fontStyleValue: FontStyle=FontStyle.Normal,
                  maxLinesValue:Int?=null,
                  backgroundColor: Color=Color.White) {
    Text(
        modifier= Modifier
            .fillMaxWidth()
            .wrapContentHeight(align = Alignment.Top)
            .background(backgroundColor)
            .padding(18.dp),
        text=value,
        fontSize=size,
        color=colorValue,
        fontWeight=fontWeightValue,
        fontStyle=fontStyleValue,
        maxLines= maxLinesValue?:Int.MAX_VALUE,
        overflow=TextOverflow.Ellipsis
    )


}


@Composable
fun SimpleButton(){
    Button(
        modifier = Modifier
            .fillMaxWidth()
            .height(68.dp),
        onClick = {
            Log.d("SimpleButton","Button Clicked!!")
        },
        shape = RoundedCornerShape(12.dp)
    ){
        NormalText(value="Click Here",TextAlign.Center)
    }
}

@Composable
fun NormalText(value: String,align: TextAlign=TextAlign.Start) {
    Text(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        text=value,
        textAlign = align,
        fontSize = 16.sp
    )

}

@Composable
fun TextFieldComponent(){
    var text by remember{
        mutableStateOf("")
    }
    TextField(
        modifier = Modifier.fillMaxWidth(),
        value = text, onValueChange = {newText->
        text=newText
    },
        textStyle = TextStyle(
            fontSize = 21.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Blue
        ),
        label = {
            NormalText(value = "Your Name")
        },
        placeholder = {
            NormalText(value = "Please Enter your Name")
        },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
    )
}

@Composable
fun ImageComponent(){
    Image(
        modifier = Modifier.wrapContentHeight().fillMaxWidth(),
        painter = painterResource(id = R.drawable.frog),
        contentDescription = "Kermit is playing in the snow")
}



@Preview
@Composable
fun VerticalScreenPreview(){
    VerticalScreen()
}
