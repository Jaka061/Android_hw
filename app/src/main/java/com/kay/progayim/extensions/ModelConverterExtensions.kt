package com.kay.progayim.extensions

import com.kay.progayim.data.models.CoursesDto
import com.kay.progayim.data.models.Courses

fun CoursesDto.toCharacters(): Courses {
    return Courses(
        id = this.id,
        name = this.name,
        status = this.status,
        species = this.species,
        type = this.type,
        gender = this.gender,
        image = this.image,
        url = this.url,
        location = this.location,
        created = this.created,
        episode = this.episode,
    )
}