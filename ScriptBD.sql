/* Versao 2.1 */

/* Tabelas do Escopo do Negocio */
CREATE TABLE Usuario (
  Email VARCHAR(25),
  Nome VARCHAR(50) NOT NULL,
  Senha VARCHAR(60) NOT NULL,
  Nota NUMERIC(4,2) DEFAULT 0,
  FotoPerfil VARCHAR,
  Sexo VARCHAR(9) NOT NULL,
  DataNasc DATE,
  Profissao VARCHAR(30),
  Cidade VARCHAR(30),
  Tipo VARCHAR(10) NOT NULL,
  CONSTRAINT Usuario_PK_Email PRIMARY KEY (Email),
  CONSTRAINT Usuario_Email_Valido CHECK (Email LIKE '%@%'),
  CONSTRAINT Usuario_Nota_Valida CHECK (Nota >= 0 AND Nota <=10),
  CONSTRAINT Usuario_Tipo_Valido CHECK (Tipo LIKE 'motorista' OR Tipo LIKE 'passageiro'),
  CONSTRAINT Usuario_Sexo_Valido CHECK (Sexo LIKE 'masculino' OR Sexo LIKE 'feminino')
);

CREATE TABLE Carro (
  Placa VARCHAR(7),
  Modelo VARCHAR NOT NULL,
  ArCondicionado BOOLEAN NOT NULL DEFAULT FALSE,
  Ano DATE,
  EmailMotorista VARCHAR(25) NOT NULL,
  CONSTRAINT Carro_PK_Placa PRIMARY KEY (Placa),
  CONSTRAINT Carro_Modelo_Valido CHECK (Modelo.length >= 5),
  CONSTRAINT Carro_FK_EmailMotorista_Usuario FOREIGN KEY (EmailMotorista) REFERENCES Usuario(Email)
);

CREATE TABLE Lugar (
  Place_id SERIAL,
  Descricao VARCHAR,
  Nome VARCHAR(50) NOT NULL,
  Lat FLOAT NOT NULL,
  Lng FLOAT NOT NULL,
  EmailUsuario VARCHAR(25) NOT NULL,
  CONSTRAINT Lugar_PK_PlaceId PRIMARY KEY (Place_id),
  CONSTRAINT Lugar_Unico_LatLng UNIQUE (Lat, Lng),
  CONSTRAINT Lugar_FK_EmailUsuario_Usuario FOREIGN KEY (EmailUsuario) REFERENCES Usuario(Email)
);

CREATE TABLE Viagem (
  Id SERIAL,
  Data DATE NOT NULL,
  Valor FLOAT NOT NULL DEFAULT 0,
  Vagas INTEGER DEFAULT 4,
  Horario TIME WITH TIME ZONE NOT NULL,
  TransportarAnimal BOOLEAN NOT NULL DEFAULT FALSE,
  NivelConversa NUMERIC NOT NULL DEFAULT 3,
  PodeFumar BOOLEAN NOT NULL DEFAULT FALSE,
  EmailMotorista VARCHAR(25) NOT NULL,
  PlacaCarro VARCHAR(7) NOT NULL,
  IdLocalSaida INTEGER NOT NULL,
  IdLocalDestino INTEGER NOT NULL,
  CONSTRAINT Viagem_PK_Id PRIMARY KEY (Id),
  CONSTRAINT Viagem_Data_Valida CHECK (Data > now()),
  CONSTRAINT Viagem_Valor_Valido CHECK (Valor >= 0),
  CONSTRAINT Viagem_Vagas_Validas CHECK (Vagas >= 0 AND Vagas <= 50),
  CONSTRAINT Viagem_NivelConversa_Valido CHECK (NivelConversa >= 0 AND NivelConversa <= 5),
  CONSTRAINT Viagem_Locais_NaoNull CHECK ((IdLocalSaida IS NOT NULL) AND (IdLocalDestino IS NOT NULL)),
  CONSTRAINT Viagem_Locais_Validos CHECK ((IdLocalSaida = IdLocalDestino) IS FALSE),
  CONSTRAINT Viagem_FK_EmailMotorista_Usuario FOREIGN KEY (EmailMotorista) REFERENCES Usuario(Email),
  CONSTRAINT Viagem_FK_PlacaCarro_Carro FOREIGN KEY (PlacaCarro) REFERENCES Carro(Placa),
  CONSTRAINT Viagem_FK_IdLocalSaida_Local FOREIGN KEY (IdLocalSaida) REFERENCES Lugar(Place_id),
  CONSTRAINT Viagem_FK_IdLocalDestino_Local FOREIGN KEY (IdLocalDestino) REFERENCES Lugar(Place_id)
);

CREATE TABLE SolicitacaoVaga (
  EmailPassageiro VARCHAR(25) NOT NULL,
  IdViagem INTEGER NOT NULL,
  CONSTRAINT SolicitacaoVaga_PK_EmailPassageiro_IdViagem PRIMARY KEY (EmailPassageiro, IdViagem),
  CONSTRAINT SolicitacaoVaga_FK_EmailPassageiro_Usuario FOREIGN KEY (EmailPassageiro) REFERENCES Usuario (Email),
  CONSTRAINT SolicitacaoVaga_FK_IdViagem_Viagem FOREIGN KEY (IdViagem) REFERENCES Viagem(Id)
);

CREATE TABLE ReservaVaga (
  EmailPassageiro VARCHAR(25) NOT NULL,
  IdViagem INTEGER NOT NULL,
  CONSTRAINT ReservaVaga_PK_EmailPassageiro_IdViagem PRIMARY KEY (EmailPassageiro, IdViagem),
  CONSTRAINT SolicitacaoVaga_FK_EmailPassageiro_Usuario FOREIGN KEY (EmailPassageiro) REFERENCES Usuario (Email),
  CONSTRAINT SolicitacaoVaga_FK_IdViagem_Viagem FOREIGN KEY (IdViagem) REFERENCES Viagem(Id)
);


/* Tabelas Referentes a Rede Social */

CREATE TABLE Follow (
  EmailSeguidor VARCHAR(25) NOT NULL,
  EmailSeguindo VARCHAR(25) NOT NULL,
  CONSTRAINT Follow_PK_EmailSeguidor_EmailSeguindo PRIMARY KEY (EmailSeguidor, EmailSeguindo),
  CONSTRAINT Follow_Emails_Diferentes CHECK ((EmailSeguidor ILIKE EmailSeguindo) IS FALSE),
  CONSTRAINT Follow_FK_EmailSeguidor_Usuario FOREIGN KEY (EmailSeguidor) REFERENCES Usuario(Email),
  CONSTRAINT Follow_PK_EmailSeguindo_Usuario FOREIGN KEY (EmailSeguindo) REFERENCES Usuario(Email)
);

CREATE TABLE Frindship (
  EmailUsuario VARCHAR(25) NOT NULL,
  EmailAmigo VARCHAR(25) NOT NULL,
  CONSTRAINT Frindship_PK_EmailUsuario_EmailAmigo PRIMARY KEY (EmailUsuario, EmailAmigo),
  CONSTRAINT Frindship_Emails_Diferentes CHECK ((EmailUsuario ILIKE EmailAmigo) IS FALSE),
  CONSTRAINT Frindship_FK_EmailUsuario_Usuario FOREIGN KEY (EmailUsuario) REFERENCES Usuario(Email),
  CONSTRAINT Frindship_PK_EmailAmigo_Usuario FOREIGN KEY (EmailAmigo) REFERENCES Usuario(Email)
);

CREATE TABLE Message (
  Id SERIAL,
  EmailEmissor VARCHAR(25) NOT NULL,
  EmailDestinatario VARCHAR(25) NOT NULL,
  Mensagem VARCHAR NOT NULL,
  CONSTRAINT Message_PK_Id PRIMARY KEY (Id),
  CONSTRAINT Message_Emails_Diferentes CHECK ((EmailSeguidor ILIKE EmailSeguindo) IS FALSE),
  CONSTRAINT Message_FK_EmailSeguidor_Usuario FOREIGN KEY (EmailSeguidor) REFERENCES Usuario(Email),
  CONSTRAINT Message_PK_EmailSeguindo_Usuario FOREIGN KEY (EmailSeguindo) REFERENCES Usuario(Email)
);

CREATE TABLE Rating (
  EmailMotorista VARCHAR(25) NOT NULL,
  EmailPassageiro VARCHAR(25) NOT NULL,
  Nota NUMERIC(4,2) DEFAULT 0,
  CONSTRAINT Rating_PK_EmailMotorista_EmailPassageiro PRIMARY KEY (EmailMotorista, EmailPassageiro),
  CONSTRAINT Rating_Emails_Diferentes CHECK ((EmailMotorista ILIKE EmailPassageiro) IS FALSE),
  CONSTRAINT Rating_Nota_Valida CHECK (Nota >= 0 AND Nota <=10),
  CONSTRAINT Rating_FK_EmailMotorista_Usuario FOREIGN KEY (EmailMotorista) REFERENCES Usuario(Email),
  CONSTRAINT Rating_PK_EmailPassageiro_Usuario FOREIGN KEY (EmailPassageiro) REFERENCES Usuario(Email)
)


