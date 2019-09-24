package modelo;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Clientes;
import modelo.Detallesorden;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-09-24T16:19:16")
@StaticMetamodel(Ordenes.class)
public class Ordenes_ { 

    public static volatile SingularAttribute<Ordenes, String> ordTelefonoEnvio;
    public static volatile SingularAttribute<Ordenes, String> ordComentario;
    public static volatile SingularAttribute<Ordenes, Date> ordFechaDespacho;
    public static volatile SingularAttribute<Ordenes, String> ordDireccionEnvio;
    public static volatile SingularAttribute<Ordenes, String> ordTipoPago;
    public static volatile ListAttribute<Ordenes, Detallesorden> detallesordenList;
    public static volatile SingularAttribute<Ordenes, Integer> ordDescuento;
    public static volatile SingularAttribute<Ordenes, Date> ordFechaOrden;
    public static volatile SingularAttribute<Ordenes, Clientes> cliNIT;
    public static volatile SingularAttribute<Ordenes, Integer> ordCodigo;
    public static volatile SingularAttribute<Ordenes, Date> ordFechaPago;
    public static volatile SingularAttribute<Ordenes, Integer> ordEstado;

}