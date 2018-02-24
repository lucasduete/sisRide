public class DaoFactory {
    
    public static DaoFactoryIF createFactory(){
        return new DaoFactoryDB();
    }
    
}

/*public class DaoFactory {
    
    public DaoFactory(){}
    
    public DaoFactoryIF getDaoFactory(){
        return DaoFactoryDB.getInstance();
    }
    
}*/