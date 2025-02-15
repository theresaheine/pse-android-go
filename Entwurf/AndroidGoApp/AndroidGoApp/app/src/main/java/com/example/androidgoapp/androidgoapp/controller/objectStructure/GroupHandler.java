package com.example.androidgoapp.androidgoapp.controller.objectStructure;

import com.example.androidgoapp.androidgoapp.controller.database.ServiceAllocation;
import com.example.androidgoapp.androidgoapp.controller.database.ServiceAppointment;
import com.example.androidgoapp.androidgoapp.controller.database.ServiceGroup;
import com.example.androidgoapp.androidgoapp.model.objectStructure.Appointment;
import com.example.androidgoapp.androidgoapp.model.objectStructure.GroupClient;
import com.example.androidgoapp.androidgoapp.model.objectStructure.UserDecoratorClient;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Theresa on 21.12.2016.
 */

public class GroupHandler {

    private List<String> grouplist;
    private ServiceAllocation sAlloc;
    private ServiceAppointment sApp;
    private ServiceGroup sGroup;

    private void updateAllGroups() {
    }

    /**
     * The actual user creates a new group on his device and becomes admin of this group by default.
     * He has to choose a unique group name.
     * The group will be added to group.db, the appointment of this group to appointment.db and that
     * the user is member of the group, there will be also a new entry in allocation.db
     * @param groupName the user wants to call his group
     * @param user who creates the group and becomes admin
     */
    public void createGroup(String groupName, UserDecoratorClient user) {
        GroupClient groupClient = new GroupClient(groupName, user);
        Appointment appointment = new Appointment();
        sGroup.insertNewGroup(groupClient);
        sApp.insertAppointment(groupClient.getGroupID(), appointment);
        sAlloc.insertNewGroupMemberAlloc(groupClient.getGroupID(), user.getUserID());
        sAlloc.updateGroupMemberToAdmin(groupClient.getGroupID(), user.getUserID());//as admin
        //TODO
    }

    /**
     * Delete groupClient from groupClient.db, delete groupClient from appointment.db, delete groupClient and member from
     * allocation.db and delete users who aren't in any other groupClient with the actual user anymore
     * from the user.db
     * @param groupClient to delete
     */
    public void deleteGroup(GroupClient groupClient){
        sApp.deleteAppointmentData(groupClient.getGroupID());
        sAlloc.deleteAllGroupMemberAlloc(groupClient.getGroupID());
        //sUser.deleteUser()
        sGroup.deleteGroupData(groupClient.getGroupID());
    }

}
