/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resto;

/**
 *
 * @author Asus
 */
public class MVC {
    public void MKN(){
        ViewMKN viewMKN = new ViewMKN();
        ModelProject modelProject = new ModelProject();
        ControllerProject controllerProject = new ControllerProject(modelProject, viewMKN);
    }
    public void MNM(){
        ViewMNM viewMNM = new ViewMNM();
        ModelProject modelProject = new ModelProject();
        ControllerProject controllerProject = new ControllerProject(modelProject, viewMNM);
    }
        public void Admin(){
        ViewAdmin viewAdmin = new ViewAdmin();
        ModelProject modelProject = new ModelProject();
        ControllerProject controllerProject = new ControllerProject(modelProject, viewAdmin);
    }

    public void PSN(){
        ViewPSN viewPSN = new ViewPSN();
        ModelProject modelProject = new ModelProject();
        ControllerProject controllerProject = new ControllerProject(modelProject, viewPSN);
    }
}
