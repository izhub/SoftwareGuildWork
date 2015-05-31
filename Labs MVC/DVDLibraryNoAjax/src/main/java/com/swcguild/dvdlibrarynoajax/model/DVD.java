/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.dvdlibrarynoajax.model;

import java.util.Objects;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author apprentice
 */
public class DVD {

    private int dvdId;

    @NotEmpty(message = "Must enter value to continue")
    @Length(max = 100, message = "value must not be longer than 100 characters")
    private String title;

    @NotEmpty(message = "Must enter value to continue")
    private String releaseDate;

    @NotEmpty(message = "Must enter value to continue")
    @Length(max = 5, message = "value must not be longer than 5 characters")
    private String mpaaRating;

    @NotEmpty(message = "Must enter value to continue")
    @Length(max = 25, message = "value must not be longer than 50 characters")
    private String director;

    @NotEmpty(message = "Must enter value to continue")
    @Length(max = 15, message = "value must not be longer than 25 characters")
    private String studio;

    @NotEmpty(message = "Must enter value to continue")
    @Length(max = 50, message = "value must not be longer than 100 characters")
    private String note;

    public int getDvdId() {
        return dvdId;
    }

    public void setDvdId(int dvdId) {
        this.dvdId = dvdId;
    }



    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getMpaaRating() {
        return mpaaRating;
    }

    public void setMpaaRating(String mpaaRating) {
        this.mpaaRating = mpaaRating;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getStudio() {
        return studio;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + this.dvdId;
        hash = 17 * hash + Objects.hashCode(this.title);
        hash = 17 * hash + Objects.hashCode(this.releaseDate);
        hash = 17 * hash + Objects.hashCode(this.mpaaRating);
        hash = 17 * hash + Objects.hashCode(this.director);
        hash = 17 * hash + Objects.hashCode(this.studio);
        hash = 17 * hash + Objects.hashCode(this.note);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final DVD other = (DVD) obj;
        if (this.dvdId != other.dvdId) {
            return false;
        }
        if (!Objects.equals(this.title, other.title)) {
            return false;
        }
        if (!Objects.equals(this.releaseDate, other.releaseDate)) {
            return false;
        }
        if (!Objects.equals(this.mpaaRating, other.mpaaRating)) {
            return false;
        }
        if (!Objects.equals(this.director, other.director)) {
            return false;
        }
        if (!Objects.equals(this.studio, other.studio)) {
            return false;
        }
        if (!Objects.equals(this.note, other.note)) {
            return false;
        }
        return true;
    }

}
