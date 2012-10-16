package org.fusesource.ide.fabric.navigator;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.fusesource.fabric.api.Profile;


public class Profiles {

	public static Set<String> getProfileIds(Profile... profiles) {
		Set<String> ids = new HashSet<String>();
		for (Profile profile : profiles) {
			ids.add(profile.getId());
		}
		return ids;
	}

	public static Profile[] toProfileArray(List<Object> selectedProfileList) {
		Set<Object> checkedProfiles = new HashSet<Object>(selectedProfileList);
		List<Profile> profileList = new ArrayList<Profile>();
		for (Object object : checkedProfiles) {
			ProfileNode node = Profiles.toProfileNode(object);
			if (node != null) {
				Profile profile = node.getProfile();
				if (profile != null) {
					profileList.add(profile);
				}
			}
		}
		Profile[] profiles = profileList.toArray(new Profile[profileList.size()]);
		return profiles;
	}

	public static ProfileNode toProfileNode(Object element) {
		if (element instanceof ProfileNode) {
			return (ProfileNode) element;
		}
		return null;
	}

	public static Profile toProfile(Object element) {
		if (element instanceof Profile) {
			return (Profile) element;
		}
		ProfileNode node = toProfileNode(element);
		if (node != null) {
			return node.getProfile();
		}
		return null;
	}

}
