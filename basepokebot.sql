CREATE DATABASE PROJPOKEBOT;
USE PROJPOKEBOT;

CREATE TABLE pokestats (
    m_Name VARCHAR(50) PRIMARY KEY,
    m_Race VARCHAR(50),
    m_Owner VARCHAR(50),
    m_level INT,
    m_xp INT,
    m_HP_max INT,
    m_HP_curr INT,
    m_dispo BOOLEAN,
    m_lastact DATE,
    m_attaques VARCHAR(2000)
    
);
