SELECT ssoid, MAX(ts) FROM public.ssdb4 WHERE grp LIKE 'dszn_%' GROUP BY ssoid;

SELECT s1.ssoid, s1.formid, s1.ts, s1.grp, s1.subtype FROM public.ssdb4 s1 WHERE s1.grp LIKE 'dszn_%'
	AND (s1.ssoid, s1.ts) IN (SELECT ssoid, MAX(ts) FROM public.ssdb4 WHERE grp LIKE 'dszn_%' GROUP BY ssoid)
	AND s1.subtype <> 'send'
	ORDER BY s1.ssoid, s1.ts;

SELECT s1.ssoid, s1.formid, MAX(s1.ts), s1.grp, s1.subtype
FROM public.ssdb4 s1 
WHERE grp 
LIKE 'dszn_%' 
GROUP BY s1.ssoid, s1.formid, s1.grp, s1.subtype 
ORDER BY s1.ssoid;


SELECT s1.ssoid, s1.formid, s1.ts, s1.grp, s1.subtype FROM public.ssdb4 s1 WHERE s1.grp LIKE 'dszn_%' AND (s1.ssoid, s1.ts) IN (SELECT ssoid, MAX(ts) FROM public.ssdb4 WHERE grp LIKE 'dszn_%' GROUP BY ssoid) AND s1.subtype <> 'send' ORDER BY s1.ssoid, s1.ts;