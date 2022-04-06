package com.kay.progayim

interface OnBtnClicked {
    fun goMain(id: Long)
    fun goToInfo(id : Long)
    fun goToAdd()
    fun goTOEdit(id: Long)
    fun goToAutor()
    fun sortByName(id: Long)
    fun sortByAge(id: Long)
    fun sortByGender(id: Long)
}
