/**
 * 
 */
package com.suman.rnd.CommonTestService.db.model;

/**
 * @author samasu5
 *
 */
public enum MajorMilestone {

	Acceptance("Acceptance"),
	NetworkEvaluation("Network Evaluation"),
	Commitment("Commitment Set"),
	Build("Build"),
	Provisioning("Provisioning"),
	Completion("Completion"),
	Cancellation("Cancellation");
	
	private String displayName;

	MajorMilestone(String displayName) {
        this.displayName = displayName;
    }

    public String displayName() { return displayName; }

    @Override public String toString() { return displayName; }
}
