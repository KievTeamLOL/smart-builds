/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.starr.smartbuilds.entity;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 *
 * @author Tanya
 */
@Entity
@Table(name = "items")
public class Item implements Serializable {

    @Id
    @Column(name = "id")
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "plaintext")
    private String plaintext;

    @Column(name = "description", columnDefinition = "text")
    private String description;

    @Column(name = "tag_str")
    private String tag_str;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "item_tag",
            joinColumns = {
                @JoinColumn(name = "item_id", referencedColumnName = "id")},
            inverseJoinColumns = {
                @JoinColumn(name = "tag_id", referencedColumnName = "id")})
    private Set<Tag> tags;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlaintext() {
        return plaintext;
    }

    public void setPlaintext(String plaintext) {
        this.plaintext = plaintext;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTag_str() {
        return tag_str;
    }

    public void setTag_str(String tag_str) {
        this.tag_str = tag_str;
    }

    public Set<Tag> getTags() {
        return tags;
    }

    public void setTags(Set<Tag> tags) {
        this.tags = tags;
    }

}
