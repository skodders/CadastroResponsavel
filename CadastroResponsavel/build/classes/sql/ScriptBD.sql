/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  Sabrina Soares
 * Created: 17/11/2018
 */

create database cadastroresponsavel;

create table Usuario (
	nome varchar(50),
	prontuario int PRIMARY KEY,
	senha varchar(30)
);

