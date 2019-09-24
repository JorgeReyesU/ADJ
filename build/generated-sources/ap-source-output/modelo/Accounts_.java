package modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Empleados;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-09-24T16:19:16")
@StaticMetamodel(Accounts.class)
public class Accounts_ { 

    public static volatile SingularAttribute<Accounts, Integer> accCod;
    public static volatile SingularAttribute<Accounts, String> accPass;
    public static volatile SingularAttribute<Accounts, Empleados> empDni;
    public static volatile SingularAttribute<Accounts, String> accUser;

}