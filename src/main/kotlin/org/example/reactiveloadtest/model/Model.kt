package org.example.reactiveloadtest.model

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table
import java.util.*

@Table
class Model(
    @Id
    val id: Long,
    val name: String,
    val createdAt: Date
)