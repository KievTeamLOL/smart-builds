/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.starr.smartbuilds.controller;

import com.starr.smartbuilds.dao.BuildDAO;
import com.starr.smartbuilds.entity.Build;
import com.starr.smartbuilds.entity.User;
import com.starr.smartbuilds.service.BuildService;
import com.starr.smartbuilds.service.FileService;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Tanya
 */
@Controller
@RequestMapping("/build")
public class BuildController {

    @Autowired
    private BuildDAO buildDAO;

    @Autowired
    private BuildService buildService;

    @Autowired
    private FileService fileService;

    @RequestMapping(method = {RequestMethod.GET})
    public String getBuild(Model model, HttpServletRequest req, HttpServletResponse resp) throws IOException, ParseException {
        Build build = new Build();
        Long buildId = 0L;
        String p = req.getParameter("id");
        if (p == null || p.equals("")) {
            System.out.println("param--" + p);
            resp.sendRedirect("./");
        } else {
            buildId = Long.parseLong(p);
            try {
                build = buildDAO.getBuild(buildId);

                model.addAttribute("author", build.getUser());
                model.addAttribute("build", build);
                model.addAttribute("champion", build.getChampion().getKeyChamp());
                model.addAttribute("blocks", buildService.parseBlocks(build.getBlocks()));
                model.addAttribute("download", fileService.getFile(build));

                HttpSession session = req.getSession();
                User user = (User) session.getAttribute("user");
                if (user == null) {
                    model.addAttribute("authMsg", "<a href='./auth'>Log in</a>");
                    model.addAttribute("exitReg", "<a href='./reg'>Register</a>");
                } else {
                    model.addAttribute("authMsg", "Hello," + user.getSummonerName() + "!");
                    model.addAttribute("exitReg", "<a href='./auth/exit'>Exit</a>");
                    model.addAttribute("createbuild", "<li><a href='./add' style='color: #deff00;'>Create Build</a></li>");
                }
            } catch (NullPointerException ex) {
                resp.sendRedirect("./");
            }

        }

        return "build";
    }
}
