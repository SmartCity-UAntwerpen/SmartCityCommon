package be.uantwerpen.sc.tools.pathplanning;

/**
 * Created by Arthur on 24/04/2016.
 */

import be.uantwerpen.sc.tools.PathplanningEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.stereotype.Component;

import java.util.List;
//RCore
@Component
public class PathplanningType {

    private PathplanningEnum type;

    @Autowired
    public PathplanningType(ApplicationArguments args) {
        boolean debug = args.containsOption("debug");
        List<String> files = args.getNonOptionArgs();
        // if run with "--debug logfile.txt" debug=true, files=["logfile.txt"]
        if(files.isEmpty()){
            type = PathplanningEnum.TERMINAL;
        }else{
            switch (files.get(0).toLowerCase()){
                case "dijkstra":
                    type = PathplanningEnum.DIJKSTRA;
                    break;
                case "random":
                    type = PathplanningEnum.RANDOM;
                    break;
                default:
                    //run default
                    type = PathplanningEnum.TERMINAL;
            }
        }
    }

    public PathplanningEnum getType() {
        return type;
    }

    public void setType(PathplanningEnum type) {
        this.type = type;
    }

}