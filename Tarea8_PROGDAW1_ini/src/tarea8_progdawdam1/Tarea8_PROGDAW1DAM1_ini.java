package tarea8_progdawdam1;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Random;
import java.util.TreeSet;

/**
 *
 * @author luis
 */
public class Tarea8_PROGDAW1DAM1_ini {

    public static void main(String[] args) {
        
        final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        //Premios
        Premio p1 = new Premio("Estancia en hotel 5 estrellas 2 noches.", "Hoteles Auger");
        Premio p2 = new Premio("Estancia en hotel 5 estrellas 1 noche.", "Hoteles Auger");
        Premio p3 = new Premio("Cena para 4 personas", "Restaurante Faro de la Magdalena");
        Premio p4 = new Premio("Cena para 2 personas", "Restaurante Faro de la Magdalena");
        Premio p5 = new Premio("Cocktail para 2 personas", "Restaurante Conchas de Asturies");
        Premio p6 = new Premio("Trofeo", "Zapatería Varo (Gijón)");
        Premio p7 = new Premio("Trofeo", "Carnicería Jose (Santander)");
        Premio p8 = new Premio("Medalla", "Papelería Shakespeare (Santander)");
        Premio p9 = new Premio("Medalla", "Kiosko Karlitos (Santurzi)");
        
        //Atletas
        Atleta luisPeres =      new Atleta("Luis Peres", "76123953K");
        Atleta antonioRosal =   new Atleta("Antonio Rosal", "82302482Y", 1);
        Atleta marcosCalderon = new Atleta("Marcos Calderon", "70024622L", 2);
        Atleta luisDelPozo =    new Atleta("Luis del Pozo", "61243903P");
        Atleta albertoArias =   new Atleta("Alberto Arias", "23951953M");
        Atleta robertoGarcia =  new Atleta("Roberto Garcia", "70134943J", 1);
        Atleta enriqueSantos =  new Atleta("Enrique Santos", "10924957S");
        Atleta rafaelCruz =     new Atleta("Rafael Cruz", "801199353A");
        
        Atleta gloriaFernandez =    new Atleta("Gloria Fernandez", "53281142O");
        Atleta raquelGomez =        new Atleta("Raquel Gomez", "79526786R", 1);
        Atleta lauraMordian =   new Atleta("Laura Mordian", "94853224K");
        Atleta cristinaDiez =   new Atleta("Cristina Diez", "25331477D", 1);
        Atleta rosaLopez =      new Atleta("Rosa Lopez", "20013958W");
        Atleta asunFrias =      new Atleta("Asun Frias", "46178951Z", 1);
        Atleta rominaGil =      new Atleta("Romina Gil", "69022973H", 1);
        Atleta doloresFresno =  new Atleta("Dolores Fresno", "72140951J");
        
        //Competiciones
        Competicion nacionalMasc =  new Competicion("Campeonato nacional masculino", 2019, 2500.0);
        Competicion nacionalFem =   new Competicion("Campeonato nacional femenino", 2019, 2500.0);
        
        //Carreras
        Carrera gijonMasc = new Carrera("Milla nocturna(MASC)", "Gijón", java.sql.Date.valueOf(LocalDate.parse("23/10/2019", dateFormatter)));
        Carrera gijonFem =  new Carrera("Milla nocturna(FEM)", "Gijón", java.sql.Date.valueOf(LocalDate.parse("23/10/2019", dateFormatter)));
            //PREMIOS
            //En la colección para los premios, el orden de inserción SÍ importa a la hora de recorrerla. Y SÍ pueden haber elementos repetidos
            //Por eso los premios se codifican con el tipo de colección LinkedList
            LinkedList<Premio> premiosGijon = new LinkedList<Premio>(); 
            //El ganador/la ganadora se lleva el p1 --> "Estancia en hotel 5 estrellas 2 noches.", "Hoteles Auger"
            premiosGijon.add(p1);
            premiosGijon.add(p2);//El segundo puesto se lleva el p2 --> "Estancia en hotel 5 estrellas 1 noche.", "Hoteles Auger"
            premiosGijon.add(p5);//El tercer puesto se lleva el p5 --> "Cocktail para 2 personas", "Restaurante Conchas de Asturies"
            //El cuarto puesto y el quinto puesto se llevan el p6 --> "Trofeo", "Zapatería Varo (Gijón)"
            premiosGijon.add(p6);
            premiosGijon.add(p6);

            //Los premios en Gijón son los mismos para la categoría masculina y la femenina
            gijonMasc.setPremios(premiosGijon);
            gijonFem.setPremios(premiosGijon);
        
            //DORSALES
            //Los dorsales se codifican mediante un diccionario (Map<K,V>) para poder acceder directamente a un dorsal (Valor-->Value) desde un atleta (Clave-->Key)
            //SÍ interesa el orden de inserción (orden de inscripción e la carrera) en esta colección a la hora de recorrerla. 
            //Además, NO puede haber 2 dorsales repetidos NI 2 atletas con el mismo dorsal NI ningún atleta sin dorsal
            //Por esa razón, se eligió codificar la relación entre Atleta-Dorsal (dorsales) mediante el tipo de colección LinkedHashMap
            LinkedHashMap<Atleta, Integer> dorsalesGijMasc = new LinkedHashMap<Atleta, Integer>();
            dorsalesGijMasc.put(luisPeres, 235);
            dorsalesGijMasc.put(albertoArias, 362);
            dorsalesGijMasc.put(antonioRosal, 102);
            dorsalesGijMasc.put(robertoGarcia, 165);
            dorsalesGijMasc.put(marcosCalderon, 337);
            dorsalesGijMasc.put(enriqueSantos, 250);
            dorsalesGijMasc.put(rafaelCruz, 252);
            dorsalesGijMasc.put(luisDelPozo, 198);
            gijonMasc.setDorsales(dorsalesGijMasc);
            System.out.println("La inscripción en " + gijonMasc.getNombre() + " de " + gijonMasc.getCiudad() + " fue la siguiente:");
            gijonMasc.imprimirDatosInscripcion(); //Apartado 2
            
            LinkedHashMap<Atleta, Integer> dorsalesGijFem = new LinkedHashMap<Atleta, Integer>();
            dorsalesGijFem.put(gloriaFernandez, 131);
            dorsalesGijFem.put(rominaGil, 299);
            dorsalesGijFem.put(rosaLopez, 309);
            dorsalesGijFem.put(raquelGomez, 177);
            dorsalesGijFem.put(asunFrias, 243);
            dorsalesGijFem.put(lauraMordian, 100);
            dorsalesGijFem.put(cristinaDiez, 159);
            dorsalesGijFem.put(doloresFresno, 171);
            gijonFem.setDorsales(dorsalesGijFem);
            System.out.println("La inscripción en " + gijonFem.getNombre() + " de " + gijonFem.getCiudad() + " fue la siguiente:");
            gijonFem.imprimirDatosInscripcion(); //Apartado 2
            
            //CLASIFICACIÓN
            //En la colección para la clasificación de la carrera.
            //SÍ interesa el orden de inserción de los atletas (que marcará la posición en que terminó cada atleta la carrera) y NO puede haber elementos repetidos
            //Por eso se codifica la clasificación mediante el tipo de dato LinkedHashSet
            LinkedHashSet<Atleta> clasifGijMasc = new LinkedHashSet<Atleta>();
            LinkedHashSet<Atleta> clasifGijFem = new LinkedHashSet<Atleta>();
            
            clasifGijMasc.add(marcosCalderon); //Marcos Calderón ganó en Gijón --> "Estancia en hotel 5 estrellas 2 noches."
            clasifGijMasc.add(antonioRosal); //Antonio Rosal quedó en segundo puesto en Gijón --> "Estancia en hotel 5 estrellas 1 noche."
            clasifGijMasc.add(robertoGarcia); // Roberto García quedó en tercer puesto en Gijón --> "Cocktail para 2 personas"
            clasifGijMasc.add(luisPeres); //Luis Peres quedó en cuarto puesto en Gijón --> "Trofeo"
            clasifGijMasc.add(albertoArias); //Alberto Arias quedó en quinto puesto en Gijón --> "Trofeo"
            clasifGijMasc.add(rafaelCruz);
            clasifGijMasc.add(luisDelPozo);
            clasifGijMasc.add(enriqueSantos);
            gijonMasc.setClasificacion(clasifGijMasc);
            
            clasifGijFem.add(cristinaDiez); //Cristina Diez ganó en Gijón --> "Estancia en hotel 5 estrellas 2 noches."
            clasifGijFem.add(raquelGomez); //Raquel Gomez quedó en segundo puesto en Gijón --> "Estancia en hotel 5 estrellas 1 noche."
            clasifGijFem.add(rominaGil); //Romina Gil quedó en tercer puesto en Gijón --> "Cocktail para 2 personas"
            clasifGijFem.add(asunFrias); //Asun Frias quedó en cuarto puesto en Gijón --> "Trofeo"
            clasifGijFem.add(rosaLopez); //Rosa Lopez quedó en quinto puesto en Gijón --> "Trofeo"
            clasifGijFem.add(doloresFresno);
            clasifGijFem.add(lauraMordian);
            clasifGijFem.add(gloriaFernandez);
            gijonFem.setClasificacion(clasifGijFem);
            
            //Salida por pantalla a través del método Carrera.toString() que está sobreescrito
            System.out.println(gijonMasc.toString());
            System.out.println(gijonFem.toString());
            
        
        Carrera santanderMasc = new Carrera("Memorial Jose Manuel Abascal(MASC)", "Santander", java.sql.Date.valueOf(LocalDate.parse("10/11/2019", dateFormatter)));
        Carrera santanderFem =  new Carrera("Memorial Jose Manuel Abascal(FEM)", "Santander", java.sql.Date.valueOf(LocalDate.parse("10/11/2019", dateFormatter)));
            //Apartado 1. Modificar el programa principal para que la se incluyan los datos sobre las carreras celebradas en Santander, tanto para la categoría masculina (santanderMasc) como para la categoría femenina (santanderFem): 
            //PREMIOS
            LinkedList<Premio> premiosSantanderMasc = new LinkedList<Premio>();
            LinkedList<Premio> premiosSantanderFem = new LinkedList<Premio>();
            
            premiosSantanderMasc.add(p2);
            premiosSantanderMasc.add(p3);
            premiosSantanderMasc.add(p7);
            premiosSantanderMasc.add(p8);
            santanderMasc.setPremios(premiosSantanderMasc);
            
            premiosSantanderFem.add(p2);
            premiosSantanderFem.add(p3);
            premiosSantanderFem.add(p7);
            santanderFem.setPremios(premiosSantanderFem);
            
            //DORSALES
            LinkedHashMap<Atleta, Integer> dorsalesSantanderMasc = new LinkedHashMap<Atleta, Integer>();
            LinkedHashMap<Atleta, Integer> dorsalesSantanderFem = new LinkedHashMap<Atleta, Integer>();
            
            dorsalesSantanderMasc.put(robertoGarcia,348);
            dorsalesSantanderMasc.put(antonioRosal, 125);
            dorsalesSantanderMasc.put(albertoArias, 254);
            dorsalesSantanderMasc.put(enriqueSantos,112);
            dorsalesSantanderMasc.put(rafaelCruz, 120);
            dorsalesSantanderMasc.put(luisDelPozo, 195);
            dorsalesSantanderMasc.put(luisPeres, 251);
            dorsalesSantanderMasc.put(marcosCalderon,275);
            santanderMasc.setDorsales(dorsalesSantanderMasc);
            System.out.println("La inscripción en " + santanderMasc.getNombre() + " de " + santanderMasc.getCiudad() + " fue la siguiente:");
            santanderMasc.imprimirDatosInscripcion();
            
            dorsalesSantanderFem.put(asunFrias, 343);
            dorsalesSantanderFem.put(gloriaFernandez,185);
            dorsalesSantanderFem.put(rominaGil, 110);
            dorsalesSantanderFem.put(cristinaDiez, 261);
            dorsalesSantanderFem.put(raquelGomez, 299);
            dorsalesSantanderFem.put(doloresFresno, 200);
            dorsalesSantanderFem.put(lauraMordian, 143);
            dorsalesSantanderFem.put(rosaLopez, 123);
            santanderFem.setDorsales(dorsalesSantanderFem);
            System.out.println("La inscripción en " + santanderFem.getNombre() + " de " + santanderFem.getCiudad() + " fue la siguiente:");
            santanderFem.imprimirDatosInscripcion();
            
            //CLASIFICACION
            LinkedHashSet<Atleta> clasificacionSantanderMasc = new LinkedHashSet<Atleta>();
            LinkedHashSet<Atleta> clasificacionSantanderFem = new LinkedHashSet<Atleta>();
            
            clasificacionSantanderMasc.add(enriqueSantos);
            clasificacionSantanderMasc.add(antonioRosal);
            clasificacionSantanderMasc.add(albertoArias);
            clasificacionSantanderMasc.add(robertoGarcia);
            clasificacionSantanderMasc.add(luisPeres);
            clasificacionSantanderMasc.add(luisDelPozo);
            clasificacionSantanderMasc.add(marcosCalderon);
            clasificacionSantanderMasc.add(rafaelCruz);
            santanderMasc.setClasificacion(clasificacionSantanderMasc);
            
            clasificacionSantanderFem.add(rosaLopez);
            clasificacionSantanderFem.add(doloresFresno);
            clasificacionSantanderFem.add(lauraMordian);
            clasificacionSantanderFem.add(asunFrias);
            clasificacionSantanderFem.add(rominaGil);
            clasificacionSantanderFem.add(raquelGomez);
            clasificacionSantanderFem.add(cristinaDiez);
            clasificacionSantanderFem.add(gloriaFernandez);
            santanderFem.setClasificacion(clasificacionSantanderFem);
            //Salida por pantalla a través del método Carrera.toString() que está sobreescrito
            System.out.println(santanderMasc.toString());
            System.out.println(santanderFem.toString());

        //COMPETICIONES
            //La colección para las carreras que componen una competición no puede tener elementos repetidos y la colección se ordena a partir de la fecha de cada carrera (de más antigua a más reciente)
            //Por ello se codifica con el tipo de dato TreeSet Y se ha implementado la interfaz Comparable (método compareTo) en la clase Carrera
            TreeSet<Carrera> carrerasNacionalMasc = new TreeSet<Carrera>();
            //Da igual que intentemos insertar primero la carrera más reciente, ya que se ordenarán según la fecha de cada Carrera insertada y NO por su orden de inserción 
            carrerasNacionalMasc.add(santanderMasc);
            carrerasNacionalMasc.add(gijonMasc);

            nacionalMasc.setCarreras(carrerasNacionalMasc);
            //Salida por pantalla de los datos de la competición al completo
            System.out.println(nacionalMasc.toString());

            TreeSet<Carrera> carrerasNacionalFem = new TreeSet<Carrera>();
            carrerasNacionalFem.add(gijonFem);
            carrerasNacionalFem.add(santanderFem);
            nacionalFem.setCarreras(carrerasNacionalFem);
            System.out.println(nacionalFem.toString());
            
            
            Carrera bilbao = new Carrera("Sal Silvestre Nochevieja", "bilbao", java.sql.Date.valueOf(LocalDate.parse("31/12/2019", dateFormatter)));
            //Apartado 5.	Diseñar los datos (e incluirlos en el programa principal) acerca de la carrera San Silvestre de Bilbao
            LinkedList<Premio> bilbaoPremios = new LinkedList<Premio>();
            
            bilbaoPremios.add(p1);
            bilbaoPremios.add(p2);
            bilbaoPremios.add(p3);
            bilbaoPremios.add(p4);
            bilbaoPremios.add(p5);
            bilbaoPremios.add(p9);
            bilbaoPremios.add(p9);
            
            bilbao.setPremios(bilbaoPremios);
            
            LinkedHashMap<Atleta, Integer> bilbaoDorsales = new LinkedHashMap<Atleta, Integer>();
            
            bilbaoDorsales.put(luisPeres, 100);
            bilbaoDorsales.put(antonioRosal, 101);
            bilbaoDorsales.put(marcosCalderon, 102);
            bilbaoDorsales.put(luisDelPozo, 103);
            bilbaoDorsales.put(albertoArias, 104);
            bilbaoDorsales.put(robertoGarcia, 105);
            bilbaoDorsales.put(enriqueSantos, 107);
            bilbaoDorsales.put(rafaelCruz, 108);
            bilbaoDorsales.put(gloriaFernandez, 109);
            bilbaoDorsales.put(raquelGomez, 110);
            
            bilbao.setDorsales(bilbaoDorsales);
            bilbao.imprimirDatosInscripcion();
            
            LinkedHashSet<Atleta> bilbaoClasificacion = new LinkedHashSet<Atleta>();
            
            bilbaoClasificacion.add(rafaelCruz);
            bilbaoClasificacion.add(luisDelPozo);
            bilbaoClasificacion.add(luisPeres);
            bilbaoClasificacion.add(albertoArias);
            bilbaoClasificacion.add(gloriaFernandez);
            bilbaoClasificacion.add(raquelGomez);
            bilbaoClasificacion.add(enriqueSantos);
            bilbaoClasificacion.add(robertoGarcia);
            bilbaoClasificacion.add(marcosCalderon);
            bilbaoClasificacion.add(antonioRosal);
            
            bilbao.setClasificacion(bilbaoClasificacion);
            System.out.println(bilbao.toString());
            
            //Comprobación de Apartado 4
            System.out.println(bilbao.inscripcionAtleta(doloresFresno));
        
    }
    
}
