public class DaoFactoryDB implements DaoFactoryIf{

    private DaoFactoryDB instance;
    
    private DaoFactoryDB(){};

}

/*public static synchronized DaoFactoryDB getInstance(){
    if(instance == null){
        return instance = new DaoFactoryDB();
    }
    return instance;
}*/