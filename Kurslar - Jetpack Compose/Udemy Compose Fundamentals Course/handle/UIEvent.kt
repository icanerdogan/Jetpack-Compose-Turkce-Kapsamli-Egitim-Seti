package com.example.composefundamentals.handle

sealed class UIEvent {
    data class ShowMessage(val message : String) : UIEvent()

}