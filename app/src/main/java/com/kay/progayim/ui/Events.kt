package com.kay.progayim.ui

import androidx.annotation.StringRes
import com.kay.progayim.data.models.Courses

sealed class Event{
    class ShowToast(@StringRes val resId: Int): Event()
    object ShowLoading: Event()
    object StopLoading: Event()
    class FetchedCh(val character: Courses): Event()
}