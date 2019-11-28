package org.smartregister.fragment;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.reflect.Whitebox;
import org.smartregister.chw.malaria.domain.MemberObject;
import org.smartregister.chw.malaria.fragment.BaseMalariaCallDialogFragment;

@PrepareForTest(BaseMalariaCallDialogFragment.class)
public class BaseMalariaCallDialogFragmentTest {
    @Spy
    public BaseMalariaCallDialogFragment baseMalariaCallDialogFragment;

    @Mock
    public ViewGroup viewGroup;

    @Mock
    public View view;

    @Mock
    public MemberObject memberObject;

    @Mock
    public Activity activity;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test(expected = Exception.class)
    public void setCallTitleFamilyHead() throws Exception {
        TextView textView = Mockito.mock(TextView.class);
        Whitebox.setInternalState(BaseMalariaCallDialogFragment.class, "MEMBER_OBJECT", memberObject);

        Mockito.when(memberObject.getBaseEntityId()).thenReturn("123456");
        Mockito.when(memberObject.getFamilyHead()).thenReturn("123456");

        Mockito.when(viewGroup.findViewById(view.getId())).thenReturn(textView);

        Whitebox.invokeMethod(baseMalariaCallDialogFragment, "setCallTitle", viewGroup, view.getId(), "message");
        Assert.assertEquals("message Head of family", textView.getText());
    }

    @Test(expected = Exception.class)
    public void setCallTitleAnc() throws Exception {
        TextView textView = Mockito.mock(TextView.class);
        Whitebox.setInternalState(BaseMalariaCallDialogFragment.class, "MEMBER_OBJECT", memberObject);

        Mockito.when(memberObject.getAncMember()).thenReturn("0");

        Mockito.when(viewGroup.findViewById(view.getId())).thenReturn(textView);

        Whitebox.invokeMethod(baseMalariaCallDialogFragment, "setCallTitle", viewGroup, view.getId(), "message");
        Assert.assertEquals("message ANC Client", textView.getText());
    }

    @Test(expected = Exception.class)
    public void setCallTitleCareGiver() throws Exception {
        TextView textView = Mockito.mock(TextView.class);
        Whitebox.setInternalState(BaseMalariaCallDialogFragment.class, "MEMBER_OBJECT", memberObject);

        Mockito.when(memberObject.getBaseEntityId()).thenReturn("123456");
        Mockito.when(memberObject.getPrimaryCareGiver()).thenReturn("123456");

        Mockito.when(viewGroup.findViewById(view.getId())).thenReturn(textView);

        Whitebox.invokeMethod(baseMalariaCallDialogFragment, "setCallTitle", viewGroup, view.getId(), "message");
        Assert.assertEquals("message Primary Caregiver", textView.getText());
    }

    @Test(expected = Exception.class)
    public void setCallTitlePnc() throws Exception {
        TextView textView = Mockito.mock(TextView.class);
        Whitebox.setInternalState(BaseMalariaCallDialogFragment.class, "MEMBER_OBJECT", memberObject);

        Mockito.when(memberObject.getPncMember()).thenReturn("0");

        Mockito.when(viewGroup.findViewById(view.getId())).thenReturn(textView);

        Whitebox.invokeMethod(baseMalariaCallDialogFragment, "setCallTitle", viewGroup, view.getId(), "message");
        Assert.assertEquals("message PNC Client", textView.getText());
    }

    @Test(expected = Exception.class)
    public void setCallTitle() throws Exception {
        TextView textView = Mockito.mock(TextView.class);
        Whitebox.setInternalState(BaseMalariaCallDialogFragment.class, "MEMBER_OBJECT", memberObject);

        Mockito.when(memberObject.getBaseEntityId()).thenReturn("1");
        Mockito.when(memberObject.getFamilyHead()).thenReturn("123456");

        Mockito.when(viewGroup.findViewById(view.getId())).thenReturn(textView);

        Whitebox.invokeMethod(baseMalariaCallDialogFragment, "setCallTitle", viewGroup, view.getId(), "message");
        Assert.assertEquals("message Malaria Client", textView.getText());
    }
}
