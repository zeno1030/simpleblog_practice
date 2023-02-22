package com.example.simpleblog.domain.post

import com.example.simpleblog.domain.AuditingEntity
import com.example.simpleblog.domain.member.Member
import javax.persistence.*

@Entity
@Table(name = "Post")

class Post(
    title:String,
    content:String,
    member:Member

): AuditingEntity() {
    @Column(name = "title", nullable = false )
    var title: String = title
        protected set

    @Column(name = "content", nullable = true )
    var content:String = content
        protected set

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Member::class)
    var member:Member = member
        protected set



}