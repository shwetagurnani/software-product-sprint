// Copyright 2019 Google LLC
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     https://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package com.google.sps.servlets;

<<<<<<< HEAD
import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;
import com.google.appengine.api.datastore.Query.SortDirection;
import com.google.gson.Gson;
import com.google.sps.Comment;
=======
import com.google.gson.Gson;
>>>>>>> 3fcd420f36420e411ab6fdc765c79254b214aaf1
import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList; 
<<<<<<< HEAD
import java.util.List;
=======
>>>>>>> 3fcd420f36420e411ab6fdc765c79254b214aaf1

/** Servlet that returns some example content. TODO: modify this file to handle comments data */
@WebServlet("/data")
public class DataServlet extends HttpServlet {

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
<<<<<<< HEAD
    Query query = new Query("Comment");

    DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
    PreparedQuery results = datastore.prepare(query);

    List<Comment> comments = new ArrayList<>();
    for (Entity entity : results.asIterable()) {
      String name = (String) entity.getProperty("name");
      String comment = (String) entity.getProperty("comment");

      Comment commentelement = new Comment(name, comment);
      comments.add(commentelement);
    }

    Gson gson = new Gson();

    response.setContentType("application/json;");
    response.getWriter().println(gson.toJson(comments));
  }
  @Override
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
    String comment = request.getParameter("comment-input");
    String name = request.getParameter("name-input");

    Entity commentEntity = new Entity("Comment");
    commentEntity.setProperty("name",name);
    commentEntity.setProperty("comment",comment);

    DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
    datastore.put(commentEntity);

    response.sendRedirect("/index.html");
  }

  // Function to convert ArrayList into JSON using Gson
  private String convertToJsonUsingGson(ArrayList comments) {
=======
    // Create ArrayList of Comments
    ArrayList<String> comments = new ArrayList<String> ();
    comments.add("Good Work");
    comments.add("Nice Work");
    comments.add("Amazing Work");

    // Convert ArrayList comments to JSON
    String json = convertToJsonUsingGson(comments);

    // Send the JSON as the response
    response.setContentType("application/json;");
    response.getWriter().println(json);
  }

    // Function to convert ArrayList into JSON using Gson
    private String convertToJsonUsingGson(ArrayList comments) {
>>>>>>> 3fcd420f36420e411ab6fdc765c79254b214aaf1
    Gson gson = new Gson();
    String json = gson.toJson(comments);
    return json;
  }
}
