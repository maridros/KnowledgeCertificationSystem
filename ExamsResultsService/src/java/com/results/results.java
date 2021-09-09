/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.results;

import java.util.ArrayList;
//import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
//import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.UriInfo;

/**
 *
 * @author Maria
 */
@Path("results") //this path is used for identify class
public class results {
    @GET
    @Path("/getAll") //this path is used for identify method
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<ExamCenterResults> getResults()
    {
        ArrayList<ExamCenterResults> results = ResultsDAO.getAllResults();
        return results;
    }
    
    /*
    
    //IT WORKS BUT I WANT TO DO IT WITH OPTIONAL QUERY PARAM!!!
    
    @GET
    @Path("/{ecid}")
    @Produces(MediaType.APPLICATION_JSON)
    public ExamCenterResults getResultsByExamCenter(@PathParam("ecid") int ecId) {
        
        ExamCenterResults ecRes = ResultsDAO.getResultsByExamCenter(ecId);
        return ecRes;   
    }
    
    @GET
    @Path("/{ecid}/{date}")
    @Produces(MediaType.APPLICATION_JSON)
    public ExamCenterResults getResultsByExamCenterAndDate(@PathParam("ecid") int ecId, @PathParam("date") String date) {
        
        ExamCenterResults ecRes = ResultsDAO.getResultsByExamCenterAndDate(ecId, date);
        return ecRes;   
    }
    
    */
    
    @GET
    @Path("examcenter/{ecid}")
    @Produces(MediaType.APPLICATION_JSON)
    public ExamCenterResults getResultsByExamCenter(@PathParam("ecid") int ecId, @QueryParam("date") String date) {
        
        ExamCenterResults ecRes = new ExamCenterResults();
        
        if (date != null) {
           ecRes = ResultsDAO.getResultsByExamCenterAndDate(ecId, date);
        } else {
           ecRes = ResultsDAO.getResultsByExamCenter(ecId);
        }
        return ecRes;   
    }
    
    /*
    @GET
    @Path("/{ecid}")
    @Produces(MediaType.APPLICATION_JSON)
    public ExamCenterResults getResultsByExamCenter(@PathParam("ecid") int ecId, @Context UriInfo uriInfo) {
        
        ExamCenterResults ecRes = new ExamCenterResults();
        MultivaluedMap<String, String> params =
                uriInfo.getQueryParameters();
        String date = params.getFirst("date");
        if (date != null) {
           ecRes = ResultsDAO.getResultsByExamCenterAndDate(ecId, date);
        } else {
           ecRes = ResultsDAO.getResultsByExamCenter(ecId);
        }
        return ecRes;   
    }
    */
    
    @GET
    @Path("/user/{uid}")
    @Produces(MediaType.APPLICATION_JSON)
    public ExamCenterResults getResultsByUser(@PathParam("uid") int uid) {
        ExamCenterResults ecRes = ResultsDAO.getResultsByUser(uid);
        return ecRes;
    }
    /*
    public ArrayList<userLog> getResults()
    {
        ArrayList<userLog> uLogs = userLogDAO.getAllResults();
        return uLogs;
    }
    */
}
