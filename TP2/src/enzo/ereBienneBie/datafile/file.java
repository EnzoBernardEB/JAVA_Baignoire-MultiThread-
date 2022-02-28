package enzo.ereBienneBie.datafile;

import enzo.ereBienneBie.logements.Appartement;
import enzo.ereBienneBie.logements.Logement;
import enzo.ereBienneBie.logements.Maison;
import enzo.ereBienneBie.menu.Menu;
import enzo.ereBienneBie.outils.Utile;
import enzo.ereBienneBie.utilisateurs.Hote;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class file {
    private static final String NOM_DU_FICHIER = "logements.xml";

    public static ArrayList<Hote> recupererHotesXML() {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

        try {
            // optional, but recommended
            // process XML securely, avoid attacks like XML External Entities (XXE)
            dbf.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);

            // parse XML file
            DocumentBuilder db = dbf.newDocumentBuilder();

            Document doc = db.parse(new File(NOM_DU_FICHIER));

            // optional, but recommended
            // http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
            doc.getDocumentElement().normalize();


            NodeList listAppartement = doc.getElementsByTagName("Appartement");

            ArrayList<Hote> retourHotes = new ArrayList<>();
            ArrayList<Logement> retourLogements = new ArrayList<>();


            for (int temp = 0; temp < listAppartement.getLength(); temp++) {

                Node node = listAppartement.item(temp);

                if (node.getNodeType() == Node.ELEMENT_NODE) {

                    Element element = (Element) node;

                    // get text
                    String tarifParNuit = element.getElementsByTagName("tarifParNuit").item(0).getTextContent();
                    String adresse = element.getElementsByTagName("adresse").item(0).getTextContent();
                    String superficie = element.getElementsByTagName("superficie").item(0).getTextContent();
                    String nbVoyageurMax = element.getElementsByTagName("nbVoyageursMax").item(0).getTextContent();
                    String numeroEtage = element.getElementsByTagName("numeroEtage").item(0).getTextContent();
                    String superficieBalcon = element.getElementsByTagName("superficieBalcon").item(0).getTextContent();
                    String nomA = element.getAttribute("name");



                    NodeList hoteNodeList = element.getElementsByTagName("hote");
                    String nom = hoteNodeList.item(0).getChildNodes().item(1).getTextContent();
                    String prenom = hoteNodeList.item(0).getChildNodes().item(3).getTextContent();
                    String age = hoteNodeList.item(0).getChildNodes().item(5).getTextContent();
                    String delai = hoteNodeList.item(0).getChildNodes().item(7).getTextContent();

                    Hote hote = new Hote(prenom,nom,Integer.parseInt(age) ,Integer.parseInt(delai));
                    Appartement appartement = new Appartement(nomA,hote,Integer.parseInt(tarifParNuit),adresse,Integer.parseInt(superficie),Integer.parseInt(nbVoyageurMax),Integer.parseInt(numeroEtage),Integer.parseInt(superficieBalcon));
                    if(!retourHotes.contains(hote)) {
                        retourHotes.add(hote);
                    } else {
                        hote = null;
                    }
                    retourLogements.add(appartement);

                }
            }

            NodeList listMaison = doc.getElementsByTagName("Maison");


            for (int temp = 0; temp < listMaison.getLength(); temp++) {

                Node node = listMaison.item(temp);

                if (node.getNodeType() == Node.ELEMENT_NODE) {

                    Element elementA = (Element) node;

                    // get text
                    String tarifParNuit = elementA.getElementsByTagName("tarifParNuit").item(0).getTextContent();
                    String adresse = elementA.getElementsByTagName("adresse").item(0).getTextContent();
                    String superficie = elementA.getElementsByTagName("superficie").item(0).getTextContent();
                    String nbVoyageurMax = elementA.getElementsByTagName("nbVoyageursMax").item(0).getTextContent();
                    String superficieJardin = elementA.getElementsByTagName("superficieJardin").item(0).getTextContent();
                    String possedePiscine = elementA.getElementsByTagName("possedePiscine").item(0).getTextContent();
                    String nomA = elementA.getAttribute("name");



                    NodeList hoteNodeList = elementA.getElementsByTagName("hote");
                    String nom = hoteNodeList.item(0).getChildNodes().item(1).getTextContent();
                    String prenom = hoteNodeList.item(0).getChildNodes().item(3).getTextContent();
                    String age = hoteNodeList.item(0).getChildNodes().item(5).getTextContent();
                    String delai = hoteNodeList.item(0).getChildNodes().item(7).getTextContent();


                    if(!retourHotes.stream().anyMatch(hote1 -> hote1.getNom().equals(nom) && hote1.getPrenom().equals(prenom)&& hote1.getAge() == Integer.parseInt(age))) {
                        Hote hote = new Hote(prenom,nom,Integer.parseInt(age) ,Integer.parseInt(delai));
                        retourHotes.add(hote);
                        Maison maison = new Maison(nomA,hote,Integer.parseInt(tarifParNuit),adresse,Integer.parseInt(superficie),Integer.parseInt(nbVoyageurMax),Integer.parseInt(superficieJardin),Integer.parseInt(possedePiscine )==1 ? true:false);
                        retourLogements.add(maison);

                    } else {
                        List<Hote> hotes = retourHotes.stream().filter(hote1 -> hote1.getNom().equals(nom) && hote1.getPrenom().equals(prenom)&& hote1.getAge() == Integer.parseInt(age)).collect(Collectors.toList());
                        Maison maison = new Maison(nomA,hotes.get(0),Integer.parseInt(tarifParNuit),adresse,Integer.parseInt(superficie),Integer.parseInt(nbVoyageurMax),Integer.parseInt(superficieJardin),Integer.parseInt(possedePiscine )==1 ? true:false);
                        retourLogements.add(maison);
                    }
                }
            }
            return retourHotes;


        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }catch (NumberFormatException e) {
            System.out.println("Probleme convertir en int");
        }
        return null;
    }

    public static ArrayList<Logement> recupererLogementsXML() {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

        try {
            // optional, but recommended
            // process XML securely, avoid attacks like XML External Entities (XXE)
            dbf.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);

            // parse XML file
            DocumentBuilder db = dbf.newDocumentBuilder();

            Document doc = db.parse(new File(NOM_DU_FICHIER));

            // optional, but recommended
            // http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
            doc.getDocumentElement().normalize();



            NodeList listAppartement = doc.getElementsByTagName("Appartement");

            ArrayList<Hote> retourHotes = new ArrayList<>();
            ArrayList<Logement> retourLogements = new ArrayList<>();


            for (int temp = 0; temp < listAppartement.getLength(); temp++) {

                Node node = listAppartement.item(temp);

                if (node.getNodeType() == Node.ELEMENT_NODE) {

                    Element element = (Element) node;

                    // get text
                    String tarifParNuit = element.getElementsByTagName("tarifParNuit").item(0).getTextContent();
                    String adresse = element.getElementsByTagName("adresse").item(0).getTextContent();
                    String superficie = element.getElementsByTagName("superficie").item(0).getTextContent();
                    String nbVoyageurMax = element.getElementsByTagName("nbVoyageursMax").item(0).getTextContent();
                    String numeroEtage = element.getElementsByTagName("numeroEtage").item(0).getTextContent();
                    String superficieBalcon = element.getElementsByTagName("superficieBalcon").item(0).getTextContent();
                    String nomA = element.getAttribute("name");


                    NodeList hoteNodeList = element.getElementsByTagName("hote");
                    String nom = hoteNodeList.item(0).getChildNodes().item(1).getTextContent();
                    String prenom = hoteNodeList.item(0).getChildNodes().item(3).getTextContent();
                    String age = hoteNodeList.item(0).getChildNodes().item(5).getTextContent();
                    String delai = hoteNodeList.item(0).getChildNodes().item(7).getTextContent();

                    Hote hote = new Hote(prenom,nom,Integer.parseInt(age) ,Integer.parseInt(delai));
                    Appartement appartement = new Appartement(nomA,hote,Integer.parseInt(tarifParNuit),adresse,Integer.parseInt(superficie),Integer.parseInt(nbVoyageurMax),Integer.parseInt(numeroEtage),Integer.parseInt(superficieBalcon));
                    if(!retourHotes.contains(hote)) {
                        retourHotes.add(hote);
                    } else {
                        hote = null;
                    }
                    retourLogements.add(appartement);

                }
            }

            NodeList listMaison = doc.getElementsByTagName("Maison");


            for (int temp = 0; temp < listMaison.getLength(); temp++) {

                Node node = listMaison.item(temp);

                if (node.getNodeType() == Node.ELEMENT_NODE) {

                    Element elementA = (Element) node;

                    // get text
                    String tarifParNuit = elementA.getElementsByTagName("tarifParNuit").item(0).getTextContent();
                    String adresse = elementA.getElementsByTagName("adresse").item(0).getTextContent();
                    String superficie = elementA.getElementsByTagName("superficie").item(0).getTextContent();
                    String nbVoyageurMax = elementA.getElementsByTagName("nbVoyageursMax").item(0).getTextContent();
                    String superficieJardin = elementA.getElementsByTagName("superficieJardin").item(0).getTextContent();
                    String possedePiscine = elementA.getElementsByTagName("possedePiscine").item(0).getTextContent();
                    String nomA = elementA.getAttribute("name");


                    NodeList hoteNodeList = elementA.getElementsByTagName("hote");
                    String nom = hoteNodeList.item(0).getChildNodes().item(1).getTextContent();
                    String prenom = hoteNodeList.item(0).getChildNodes().item(3).getTextContent();
                    String age = hoteNodeList.item(0).getChildNodes().item(5).getTextContent();
                    String delai = hoteNodeList.item(0).getChildNodes().item(7).getTextContent();


                    if(!retourHotes.stream().anyMatch(hote1 -> hote1.getNom().equals(nom) && hote1.getPrenom().equals(prenom)&& hote1.getAge() == Integer.parseInt(age))) {
                        Hote hote = new Hote(prenom,nom,Integer.parseInt(age) ,Integer.parseInt(delai));
                        retourHotes.add(hote);
                        Maison maison = new Maison(nomA,hote,Integer.parseInt(tarifParNuit),adresse,Integer.parseInt(superficie),Integer.parseInt(nbVoyageurMax),Integer.parseInt(superficieJardin),Integer.parseInt(possedePiscine )==1 ? true:false);
                        retourLogements.add(maison);

                    } else {
                        List<Hote> hotes = retourHotes.stream().filter(hote1 -> hote1.getNom().equals(nom) && hote1.getPrenom().equals(prenom)&& hote1.getAge() == Integer.parseInt(age)).collect(Collectors.toList());
                        Maison maison = new Maison(nomA,hotes.get(0),Integer.parseInt(tarifParNuit),adresse,Integer.parseInt(superficie),Integer.parseInt(nbVoyageurMax),Integer.parseInt(superficieJardin),Integer.parseInt(possedePiscine )==1 ? true:false);
                        retourLogements.add(maison);
                    }
                }
            }
            return retourLogements;

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }catch (NumberFormatException e) {
            System.out.println("Probleme convertir en int");
        }
        return null;
    }
}
