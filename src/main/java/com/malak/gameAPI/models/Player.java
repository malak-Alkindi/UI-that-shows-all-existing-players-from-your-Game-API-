package com.malak.gameAPI.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity

public class Player {
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   public int id;

   public String name;
   public String gender ;
   public String country ;


}
