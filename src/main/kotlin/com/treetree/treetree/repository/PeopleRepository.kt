package com.treetree.treetree.repository

import com.treetree.treetree.model.People
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PeopleRepository : JpaRepository<People, Long>
