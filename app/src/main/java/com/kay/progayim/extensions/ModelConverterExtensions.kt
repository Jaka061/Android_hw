package com.kay.progayim.extensions

import com.kay.progayim.data.models.CharacterDto
import com.kay.progayim.data.models.Characters

fun CharacterDto.toCharacters(): Characters {
    return Characters(
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