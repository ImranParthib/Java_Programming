package com.example.employeemanagementsystem;

import eu.hansolo.tilesfx.Tile;
import eu.hansolo.tilesfx.TileBuilder;
import javafx.scene.layout.GridPane;

public class DashboardView extends GridPane {

    public DashboardView() {
        Tile totalEmployeesTile = TileBuilder.create()
                .skinType(Tile.SkinType.NUMBER)
                .title("Total Employees")
                .value(0)
                .build();

        Tile employeesByDepartmentTile = TileBuilder.create()
                .skinType(Tile.SkinType.BAR_CHART)
                .title("Employees by Department")
                .build();

        Tile activeEmployeesTile = TileBuilder.create()
                .skinType(Tile.SkinType.GAUGE)
                .title("Active Employees")
                .value(0)
                .build();

        add(totalEmployeesTile, 0, 0);
        add(employeesByDepartmentTile, 1, 0);
        add(activeEmployeesTile, 2, 0);
    }
}