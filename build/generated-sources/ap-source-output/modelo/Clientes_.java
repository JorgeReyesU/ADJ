package modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Ordenes;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-09-26T15:24:36")
@StaticMetamodel(Clientes.class)
public class Clientes_ { 

    public static volatile SingularAttribute<Clientes, String> cliNombre;
    public static volatile SingularAttribute<Clientes, String> cliTelefono;
    public static volatile SingularAttribute<Clientes, Integer> cliDescuento;
    public static volatile SingularAttribute<Clientes, String> cliDireccion;
    public static volatile ListAttribute<Clientes, Ordenes> ordenesList;
    public static volatile SingularAttribute<Clientes, String> cliNIT;
    public static volatile SingularAttribute<Clientes, String> cliApellido;
    public static volatile SingularAttribute<Clientes, String> cliEmail;
    public static volatile SingularAttribute<Clientes, String> cliTipoCliente;

}